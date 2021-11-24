package teamResult;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;



class TeamResult{
    String competition;
    int year;
    String round;
    String team1;
    int team1goals;
    String team2;
    int team2goals;

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public int getTeam1goals() {
        return team1goals;
    }

    public void setTeam1goals(int team1goals) {
        this.team1goals = team1goals;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam2goals() {
        return team2goals;
    }

    public void setTeam2goals(int team2goals) {
        this.team2goals = team2goals;
    }
}

class ResultList{

    int page;
    int per_page;
    int total;
    int total_pages;
    List<TeamResult> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<TeamResult> getData() {
        return data;
    }

    public void setData(List<TeamResult> data) {
        this.data = data;
    }
}

//Matches by team
public class Result {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static int getTotalGoalsByType(String team, int year, boolean isHome) throws IOException {

        boolean ok = true;
        int page = 1;
        int result = 0;

        while(ok){
            String urlStringHome = "https://jsonmock.hackerrank.com/api/football_matches?year="+year
                    +"&team"+ (isHome? 1: 2)  + "=" + team
                    + "&page=" + page;
            URL urlHome = new URL(urlStringHome);
            HttpURLConnection connHome = (HttpURLConnection) urlHome.openConnection();
            connHome.setRequestMethod("GET");
            connHome.connect();
            int responseCode = connHome.getResponseCode();
            if(responseCode == 200){
                BufferedReader rd = new BufferedReader(new InputStreamReader(connHome.getInputStream(), Charset.forName("UTF-8")));
                String jsonString = readAll(rd);
                Gson gson = new Gson();
                ResultList resultList = gson.fromJson(jsonString, ResultList.class);
                for(TeamResult teamResult: resultList.getData()){
                    result += isHome ? teamResult.getTeam1goals() : teamResult.getTeam2goals();
                }
                if(page == resultList.total_pages){
                    ok = false;
                }else{
                    page++;
                }
            }else{
                ok = false;
            }

        }

        return result;
    }

    /*
     * Complete the 'getNumDraws' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER year as parameter.
     */

    public static int getNumDraws(int year) throws IOException {
        int page = 1;
        int result = 0;
        for(int i=0; i<=10; i++) {
            String urlStringHome = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year
                    + "&team1goals=" + i + "&team2goals=" + i
                    + "&page=" + page;
            URL urlHome = new URL(urlStringHome);
            HttpURLConnection connHome = (HttpURLConnection) urlHome.openConnection();
            connHome.setRequestMethod("GET");
            connHome.connect();
            int responseCode = connHome.getResponseCode();
            if (responseCode == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(connHome.getInputStream(), Charset.forName("UTF-8")));
                String jsonString = readAll(rd);
                Gson gson = new Gson();
                ResultList resultList = gson.fromJson(jsonString, ResultList.class);
                result += resultList.total;

            }

        }

        return result;
    }

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

    public static int getTotalGoals(String team, int year)  {
        int result = 0;

        try {
            result += getTotalGoalsByType(team, year, true);
            result += getTotalGoalsByType(team, year, false);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    public static void main (String argv[]) throws IOException {
        //System.out.println(Result.getTotalGoals("Barcelona", 2011));
        System.out.println(Result.getNumDraws(2011));
    }
}
