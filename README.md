# microservices-overhead-testing
Emprical analysis of microservices based MRS with audit logging capabilities.


This is a testing tool for analysing runtime overhead of MRS with micro services architecture.
The re are four different scenarios that have been considered for this purpose:
1) study the effect of the instrumentation when no trigger or logging event is required.
2) study the extreme case of the system, when all the actions are triggers.
3) study the effect of a more realistic situation with a portion of the actions to be logging event.
4) study the overhead of a multi-user experiene where all of the users log in and a portion of them trigger logging events.

