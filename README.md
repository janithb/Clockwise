# Clockwise
Lightweight Java task scheduler inspired by Spring framework scheduler.

Examples:

```java

String id = Schedulers.newDefault().schedule(
        new TriggerTask(new PrintTask(), new PeriodicTrigger(1000))); //(Scheduler 1) Schedules a task for every one second.

System.out.println(id); // Prints the scheduler id.

String id2 = Schedulers.newDefault().schedule(
        new TriggerTask(new PrintTask(), new PeriodicTrigger(2000))); // (Scheduler 2) Schedules an another task for every two second.

System.out.println(id2); // Prints the scheduler 2 id.

System.out.println(Schedulers.getRunningSchedulerCount()); // Prints the running scheduler counts. This will prints '2'

TimeUnit.SECONDS.sleep(5); // Sleep for five seconds

Schedulers.stop(id2); // Stops the scheduler 2

System.out.println(Schedulers.getRunningSchedulerCount()); // Prints the running scheduler counts. This will prints '1'

TimeUnit.SECONDS.sleep(5); // Sleep for five seconds

Schedulers.stopAll(); // Stop all running schedulers.

System.out.println("Executing threadpool scheduler");
String id3 = Schedulers.newThreadPoolScheduler(4).schedule(
        new TriggerTask(new PrintTask(), nnew CronTrigger("0/4 * * * * *"))); // (Scheduler 3) Schedules an another task for every four seconds. This uses cron expression.

System.out.println(id3); // Prints the scheduler 3 id.

TimeUnit.SECONDS.sleep(40); // Sleep for fourty seconds

Schedulers.stopAll(); // Stop all running schedulers.
