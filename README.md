# Clockwise
Lightweight Java task scheduler inspired by Spring framework scheduler.

Examples:

```java

String id = Schedulers.newDefault().schedule(
        new TriggerTask(new PrintTask(), new PeriodicTrigger(1000))); // (1)

System.out.println(id); // (2)

String id2 = Schedulers.newDefault().schedule(
        new TriggerTask(new PrintTask(), new PeriodicTrigger(2000))); // (3)

System.out.println(id2); // (4)

System.out.println(Schedulers.getRunningSchedulerCount()); // (5)

TimeUnit.SECONDS.sleep(5); // (6)

Schedulers.stop(id2); // (7)

System.out.println(Schedulers.getRunningSchedulerCount()); // (8)

TimeUnit.SECONDS.sleep(5); // (9)

Schedulers.stopAll(); // (10)

System.out.println("Executing threadpool scheduler");
String id3 = Schedulers.newThreadPoolScheduler(4).schedule(
        new TriggerTask(new PrintTask(), nnew CronTrigger("0/4 * * * * *"))); // (11)

System.out.println(id3); // (12)

TimeUnit.SECONDS.sleep(40); // (13)

Schedulers.stopAll(); // (14)

```

1. Scheduler 1: Schedules a task for every one second.
2. Prints the scheduler id.
3. Scheduler 2 Schedules an another task for every two second.
4. Prints the scheduler 2 id.
5. Prints the running scheduler counts. This will prints '2'
6. Sleep for five seconds
7. Stops the scheduler 2
8. Prints the running scheduler counts. This will prints '1'
9. Sleep for five seconds
10. Stop all running schedulers.
11. Scheduler 3: Schedules an another task for every four seconds. This uses cron expression.
12. Prints the scheduler 3 id.
13. Sleep for fourty seconds.
14. Stop all running schedulers.
