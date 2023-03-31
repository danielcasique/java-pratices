package org.casique.oop.designPattern.structural.proxy;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

interface Internet
{
    public void connectTo(String serverhost) throws Exception;
}

class RealInternet implements Internet
{
    @Override
    public void connectTo(String serverhost)
    {
        System.out.println("Connecting to "+ serverhost);
    }
}

class ProxyInternet implements Internet
{
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception
    {
        if(bannedSites.contains(serverhost.toLowerCase()))
        {
            throw new Exception("Access Denied");
        }

        internet.connectTo(serverhost);
    }

}

public class Proxy
{
    public static void main (String[] args)
    {
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Long.toOctalString(Instant.now().toEpochMilli()));
        System.out.println(Long.toHexString(Instant.now().toEpochMilli()));
        Internet internet = new ProxyInternet();
        try
        {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}