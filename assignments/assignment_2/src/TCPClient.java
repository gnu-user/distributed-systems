import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


import com.google.common.primitives.Doubles;

public class TCPClient
{
    /* Connection objects */
    private static Socket s = null;
    private static DataInputStream in = null;
    private static DataOutputStream out = null;
    
    /* The data used for the test */
    private static Integer testSize = 25600;  // Default 25KB
    private static char[] messageTest;

    /* The variables used for calculating mean delay, packet loss, throughput */
    private static ArrayList<Double> delayBuffer = new ArrayList<Double>();
    private static LinkedHashMap<Integer, Double> meanDelay = new LinkedHashMap<Integer, Double>();
    private static LinkedHashMap<Integer, Integer> packetLoss = new LinkedHashMap<Integer, Integer>();
    private static LinkedHashMap<Integer, Double> throughput = new LinkedHashMap<Integer, Double>();
    
    private static Integer packetLossCount = 0;
    private static Integer totalPacketLoss = 0;
    
    
    /* Calculates the mean delay, packet loss, and throughput, and the total 
     * packet loss for the current data.
     */
    public static void calcStats()
    {
        Integer index = meanDelay.size() + 1;
        DescriptiveStatistics descStats = new DescriptiveStatistics(Doubles.toArray(delayBuffer));
        meanDelay.put(index, descStats.getMean());
        
        packetLoss.put(index, packetLossCount);
        totalPacketLoss += packetLossCount;
        
        /* Throughput as bits/sec is the (data size in bytes) / (mean delay ms) * 1000 */
        throughput.put(index, ((testSize * 1024) / descStats.getMean()) * 1000);
        
        /* Reset buffers / counters */
        delayBuffer.clear();
        packetLossCount = 0;
    }
    
    
    // arguments supply test type and hostname of destination
    public static void main(String args[]) throws InterruptedException
    {
        /* Create the data buffer used for the test based on the size given in kb */
        testSize = new Integer(args[0]);
        messageTest = new char[testSize * 1024];
        Arrays.fill(messageTest, 'A');
                
        /* Used for calculating the benchmarks */
        boolean successful = false;
        long startTime = 0;
        long endTime = 0;
        
        /* Perform the test for 100,000 messages, log the results */
        for (int i = 1; i <= 10000; ++i)
        {
            try
            {
                /* Get the socket connection */
                int serverPort = 7896;
                s = new Socket();
                s.connect(new InetSocketAddress(args[1], serverPort), 250);
                in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());
                
                /* Calculate the delay */
                startTime = System.nanoTime();
                out.writeUTF(new String(messageTest)); // UTF is a string encoding see Sn 4.3
                String data = in.readUTF();
                endTime = System.nanoTime();

                System.out.println("Received packet: " + i);
                successful = true;
            }
            catch (SocketTimeoutException e)
            {
                System.out.println("Socket timeout: " + e.getMessage());
            }
            catch (UnknownHostException e)
            {
                System.out.println("Sock:" + e.getMessage());
            }
            catch (EOFException e)
            {
                System.out.println("EOF:" + e.getMessage());
            }
            catch (IOException e)
            {
                System.out.println("IO:" + e.getMessage());
            }
            finally
            {
                /* If the packet was received successfully add delay to buffer */
                if (successful)
                {
                    delayBuffer.add(new Double((endTime - startTime) / 1000000));
                    successful = false;
                }
                else
                {
                    ++packetLossCount;
                }
            }
            
            /* If this is the 1000th datapoint, calculate the mean delay, 
             * packetloss, throughput */
            if ((i % 100) == 0)
            {
                calcStats();
            }
        }
        
        System.out.println(packetLossCount);
        
        /* Save the results to CSV files */
        OutputWriter ow = new OutputWriter("/mnt/home/jon/University/TERM 4A/SOFE 4790U/Assignments/Assignment 2/data/");
        ArrayList<String> columnsDelay = new ArrayList<String>()
                {{ add("packet_thous"); add("mean_delay");}};
        ArrayList<String> columnsPacketLoss = new ArrayList<String>()
                        {{ add("packet_thous"); add("packet_loss");}};
        ArrayList<String> columnsThroughput = new ArrayList<String>()
                                {{ add("packet_thous"); add("throughput");}};
        
        try
        {
            ow.saveResults(meanDelay, columnsDelay, "TCP_mean_delay_" + testSize.toString() + "KB.csv");
            ow.saveResults(packetLoss, columnsPacketLoss, "TCP_packet_loss_" + testSize.toString() + "KB.csv");
            ow.saveResults(throughput, columnsThroughput, "TCP_throughput_" + testSize.toString() + "KB.csv");
        }
        catch (IOException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        

        /* Close the socket */
        if (s != null)
        {
            try
            {
                s.close();
            }
            catch (IOException e)
            {
                System.out.println("close:" + e.getMessage());
                System.exit(1);
            }
        }
    }
}
