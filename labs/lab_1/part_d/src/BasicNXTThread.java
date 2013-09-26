import lejos.nxt.*;
import lejos.pc.comm.*;

public class BasicNXTThread extends Thread {
	 NXTComm NXTConn;

	public void run() {
		try {
			/* Read light sensor value */
			LightSensor lightSensor = new LightSensor(SensorPort.S1);
			
			for (int i = 0; i < 10; ++i)
			{
				NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
				Motor.A.forward();
				/* wait for a while */
				sleep(100);
				
				System.out.print("NXT light sensor value is: ");
				System.out.println(lightSensor.getLightValue());
			}
			lightSensor.setFloodlight(false);
			
			Motor.A.stop();
		}
		
		catch(NXTCommException e) {
			System.out.println("Error - creating NXT connection");
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
