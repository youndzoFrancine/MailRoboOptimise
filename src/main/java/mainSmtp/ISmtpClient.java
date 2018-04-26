/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainSmtp;



import model.Message;
import model.Prank;

import java.io.IOException;

/**
 * @author Marie Lemdjo
 * @author Francine Youndzo
 * 
 * Interface pour la classe impl�mentant le protocole SMTP
 */
public interface ISmtpClient {
    public void sendMessage(String serverName, int port, Prank p) throws IOException, SmtpException;
}

