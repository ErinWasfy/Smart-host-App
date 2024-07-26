--Hotel Room Allocation Task Documentation
Java Version used :17 (jdk-17)
Default local server port:8080

a) An entity package is created that includes request and response classes as these classes are used in the API post endpoint so as
to send request(CreateHotelAllocationDTO) and receive the result (HotelOccupancyDTO);

b) RestController class (HotelAllocationRestController) added to handle the API endpoints and
a method named as "saveHotelRoomOccupancyDetails" created to implement the occupancy of the hotel allocation and return
the result of the outcome in the model package of dto(HotelOccupancyResultDto) that includes usage Premium, usage Economy,
revenue premium and revenue economy.

c) A service (HotelAllocationService) added to hold the business logic of the transaction.It involves the method(
saveHotelOccupancyDetails) to implement the occupancy of the hotel allocation with respect of number of premium rooms
and number of economy rooms.

d)ControllerExceptionHandler is a class that is annotated with controllerAdvice so as to handle the
entire exceptions of Rest controller of APIs globally.

e) I created unit testing(HotelAllocationServiceTest),integration testing(HotelAllocationRestControllerTest) and
acceptance testing(HotelAllocationAcceptanceTest) to fulfill most of the test cases mentioned in the task
requirements.
