package practice;

public class AnonymousThread {

	public static void main(String[] args) {
	
		// create an object of an anonymous class, which has extended the Thread class and has overridden its run() method.
		Thread t = new Thread() {
			public void run() {
				setName("Anonymous Thread extends Thread Class");
				System.out.println("Name of the other thread: " +getName());
				for(int i=0; i<3; i++)
					System.out.println(getName() +" "+i);
			}
		};
		t.start();
		System.out.println("Name of main thread: "+ Thread.currentThread().getName());
		
		
		// create an object of an anonymous class, which has implemented the Runnable interface and its run() method.
		Runnable r = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Thread t = Thread.currentThread();
				t.setName("Anonymous Thread extends Runnable Interface");
				System.out.println("Name of the other thread: " + t.getName());
				for (int i = 0; i < 3; i++)
					System.out.println(t.getName() + " " + i);
			}
		};
		r.run();
	}

}
