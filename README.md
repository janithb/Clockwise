# Clockwise
Lightweight Java task scheduler inspired by Spring framework scheduler.

Examples:

```java

String id = Schedulers.newDefault().schedule(new TriggerTask(new PrintTask(), new PeriodicTrigger(1000)));

System.out.println(id);

String id2 = Schedulers.newDefault().schedule(new TriggerTask(new PrintTask(), new PeriodicTrigger(2000)));

System.out.println(id2);

System.out.println(Schedulers.getRunningSchedulerCount());

TimeUnit.SECONDS.sleep(5);

Schedulers.stop(id2);

System.out.println(Schedulers.getRunningSchedulerCount());

TimeUnit.SECONDS.sleep(5);

Schedulers.stopAll();

System.out.println("Executing threadpool");
String id3 = Schedulers.newThreadPoolScheduler(4).schedule(
        new TriggerTask(new PrintTask(), new PeriodicTrigger(1000)));

System.out.println(id3);

TimeUnit.SECONDS.sleep(5);

Schedulers.stopAll();
