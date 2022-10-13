package com.timwang5.mall.util;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author timwong5
 * @date 2022-08-15 22:56
 */
public class PortUtil {

    /**
     * 测试端口连接
     * @param port
     * @return
     */
    public static boolean testPort(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            ss.close();
            return false;
        } catch (java.net.BindException e) {
            return true;
        } catch (IOException e) {
            return true;
        }
    }

    /**
     * 检查端口是否启动
     * @param port
     * @param server
     * @param shutdown
     */
    public static void checkPort(int port, String server, boolean shutdown) {
        if (!testPort(port)) {
            if (shutdown) {
                String message = String.format("在端口 %d 未检查得到 %s 启动%n", port, server);
                JOptionPane.showMessageDialog(null, message);
                System.exit(1);
            } else {
                String message = String.format("在端口 %d 未检查得到 %s 启动%n,是否继续?", port, server);
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(null, message)) {
                    System.exit(1);
                }

            }
        }
    }
}
