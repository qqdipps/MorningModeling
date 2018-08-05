import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * object alarm: models behaviors of setting alarm, alarm going off and then being set to snooze,
 * and then going off again, # of times snooze occurs dependent on volume of alarm, 
 * time and alarm volume set is dependent on day 
 * @return
 */
public class Alarm{
		/**
		 * time alarm is set
		 */
		public LocalTime AlarmSetTime ;
		/**
		 * time alarm goes off
		 */
		public LocalTime AlarmGoingOffTime;
		/**
		 * volume of alarm
		 */
		public static int alarmVolume;
		/**
		 * constructor creates alarm object and initializes variables using parameters
		 * of object passed from 
		 * public static Alarm wakingUp(String dayOfWeek). 
		 * variables are used in subsequent methods setAlarm() and snooze
		 * 
		 * @param AlarmSetTime
		 * @param alarmVolume
		 */
		public Alarm(LocalTime AlarmSetTime, int alarmVolume){
			Alarm.alarmVolume = alarmVolume;
			this.AlarmSetTime = AlarmSetTime;
			AlarmGoingOffTime = AlarmSetTime;
			setAlarm();
			snooze();
		}
		/**
		 * prints to console alarm time and alarm sound
		 */
		public void setAlarm(){	
			System.out.print(AlarmGoingOffTime + " Ring!! Ring!! Buzzz!! Good Morning!!");
		}		
		/**
		 * alarm volume determines how many times snooze occurs. Each time snooze occurs 
		 * alarm is silenced for 5 mins. Alarm time is updated. calls setAlarm() which prints 
		 * alarm time and alarm sound to console, also returns advice wake up time is > 20 mins
		 * after set time.
		 * @return
		 */
		public String snooze(){
			String advice;
			if (alarmVolume < 5) {
				advice = " YOU'RE LATE! Next time set Alarm louder so you wake up on time.";
			}
			else {
				advice = "Have a great day!";	
			}
			for(int i = alarmVolume; i<7; i++){
				System.out.println(" snooze");
				System.out.print("zzz...");
				Duration snoozeTime = Duration.ofMinutes(5*(i-alarmVolume+1));
				AlarmGoingOffTime = AlarmSetTime.plus(snoozeTime);
				setAlarm();
			}
			String AlarmGoingOff = AlarmGoingOffTime.toString();
			System.out.println(" ");
			System.out.println(advice);
			return AlarmGoingOff;	}
		/**
		 * method uses switch to call to create object based on day of week passed
		 * as parameter. method is static so able to be called in main method prior
		 * to object created. includes additional print statement for day of week. 
		 * @param dayOfWeek
		 * @return
		 */
		public static Alarm wakingUp(String dayOfWeek){
			switch (dayOfWeek){
				case "Monday" :
					System.out.println("MONDAY!!!!");
					Alarm MondaySetAlarm = new Alarm(LocalTime.of(6,30),2);
					return MondaySetAlarm;
				case "Tuesday" :
					System.out.println("TUESDAY!!!");
					Alarm TuesdaySetAlarm = new Alarm(LocalTime.of(8,0),4);
					return TuesdaySetAlarm;
				case "Wednesday" :
					System.out.println("WEDNESDAY!!!");
					Alarm WednesdaySetAlarm = new Alarm(LocalTime.of(8,0),8);
					return WednesdaySetAlarm;
				case "Thursday" :
					System.out.println("TURHSDAY!!!");
					Alarm ThursdaySetAlarm = new Alarm(LocalTime.of(8,0),3);
					return ThursdaySetAlarm;
				case "Friday" :
					System.out.println("FRIDAY!!!!");
					Alarm FridaySetAlarm = new Alarm(LocalTime.of(8,0),6);
					return FridaySetAlarm;
				
			}
			Alarm weekendSetAlarm = new Alarm(LocalTime.of(10,0),8);
			System.out.println(" Go back to bed, its the weekend!!!"); 
			System.out.println(" ");
			return weekendSetAlarm;
		}
		/**
		 * prints all scenarios to console
		 * @param args
		 */
			public static void main(String[] args)  {
				
				String[] daysOfWeek = { "Monday","Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
				for(int i = 0; i < daysOfWeek.length; i++) {
					wakingUp(daysOfWeek[i]);
					System.out.println(" ");
				}
			
		}
				

		
		
		


			
	}

