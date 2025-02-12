package sec2;

//Tread(쓰레드) : Process(프로세스) = 현재 컴퓨터에서 실행 중인 프로그램(작업)
//발생 => (실행대기:RUNNABLE)=> 점유(실행:RUN) => (실행대기:RUNNABLE)=> 종료
//실행=> 실행대기 : sleep
//실행대기 => 실행 : wake up(run)

public class ThreadExam1 {
	public static void firstThread() {
		System.out.println("첫 번째 쓰레드");
	}
	public static void secondaryThread() {
//		System.out.println("두 번째 쓰레드");
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<10;i++) {
//			toolkit.beep();
			System.out.println(i);
			try {
				Thread.sleep(1000); //쓰레드를 잠시 정지.? sleep(1000)이 1초 정지되었다가 실행..
			}catch(InterruptedException e) {//sleep(실행=> 실행대기)
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() { // //new Thread(생성) => Runnable(실행 대기)

			@Override
			public void run() {	//run(실행대기 -> 실행) 
				firstThread();
			}
		});	//쓰레드(실행가능한 작업)
		//thread1.run();
		//thread1.start();
		System.out.println(thread1.getName());
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				secondaryThread();
			}
		});
		thread2.start();
		
	}
}
