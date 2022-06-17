package jh.utils.sftp;

import com.jcraft.jsch.*;

import java.util.Properties;

public class Sftp {

    private static final String username = "root";
    private static final String host = "106.53.121.164";
    private static final Integer port = 22;

    public static void main(String[] args) throws JSchException, SftpException {

        JSch jsch = new JSch();
        jsch.getSession(username, host, port);
        Session sshSession = jsch.getSession(username, host, port);
        sshSession.setPassword("Jinghua1.");
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();

        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        ChannelSftp sftp = (ChannelSftp) channel;

        System.out.println(sftp.ls("/"));
        System.out.println(sftp.pwd());

    }

}
