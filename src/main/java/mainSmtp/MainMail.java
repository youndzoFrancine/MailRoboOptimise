/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainSmtp;
import configuration.ConfigurationManager;
import configuration.IConfiguration;
import model.Message;
import model.Person;
import model.Prank;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import model.PrankGenerator;

/**
 *
 * @author youndzofrancine
 */
public class MainMail {
     //Faire en sorte de demander le nombre de groupe de personne
    public static void main(String[] argv) throws IOException {
    
        IConfiguration conf = new ConfigurationManager();

        //liste contenant les pranks
        List<Prank> pranks = new LinkedList<Prank>();
        //génération liste de panks
        PrankGenerator gPranks = new PrankGenerator(conf);
        pranks = gPranks.generatePranks();

        //nom du serveur
        String serverName = conf.getServerAddress();

        //numèro du port
        int serverPort = conf.getServerport();

        SmtpClient smtp = new SmtpClient();
        try {
            for (Prank p : pranks) {
                System.err.println("Error while sending: ");
                smtp.sendMessage(serverName, serverPort, p);
            }
        } catch (Exception e) {
            System.err.println("Error while sending: " + e.toString());
            e.printStackTrace();
        }
        System.exit(0);
    }
}

