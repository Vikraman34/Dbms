REM Advanced DML: Nested Queries, Joins, Set Operations


REM 1. Display the flight number,departure date and time of a flight, its route details and aircraft name of type either Schweizer or Piper that departs during 8.00 PM and 9.00 PM.

SELECT fs.flno,fs.departs,fs.dtime,
	r.routeid,r.orig_airport,r.dest_airport,r.distance, 
	a.aname AS "Aircraft name"
FROM Fl_schedule fs,Flights f,Routes r,Aircraft a
WHERE (fs.flno=f.flightno) AND 
	(f.rid=r.routeid) AND
	(f.aid=a.aid) AND
	(fs.dtime BETWEEN 2000 AND 2100) AND
	(a.type='Schweizer' OR a.type='Piper')
ORDER BY r.distance;





REM 2. For all the routes, display the flight number, origin and destination airport, if a flight is assigned for that route.

SELECT r.routeID,f.flightNo,r.orig_airport,r.dest_airport
FROM Routes r LEFT JOIN Flights f
ON r.routeID=f.rID
ORDER BY r.routeID,f.flightNo;





REM 3. For all aircraft with cruisingrange over 5,000 miles, find the name of the aircraft and the average salary of all pilots certified for this aircraft.

SELECT a.aname,AVG(e.salary)
FROM Aircraft a,Employee e,Certified c
WHERE (a.cruisingrange > 5000) AND
	((a.aid=c.aid) AND(c.eid=e.eid))
GROUP BY a.aname
ORDER BY a.aname;





REM 4. Show the employee details such as id, name and salary who are not pilots and whose salary is more than the average salary of pilots.

SELECT e.eid,e.ename,e.salary
FROM Certified c RIGHT JOIN Employee e
ON e.eid=c.eid
WHERE c.eid IS NULL AND
	e.salary > 
		(SELECT AVG(salary)
		 FROM Employee e,Certified c
		 WHERE e.eid=c.eid);


		


REM 5. Find the id and name of pilots who were certified to operate some aircrafts but at least one of that aircraft is not scheduled from any routes.

SELECT DISTINCT e.eid,e.ename
FROM Employee e,Certified c 
WHERE e.eid=c.eid AND c.aid IN
	(SELECT c.aid
	 FROM Certified c LEFT JOIN Flights f
	 ON c.aid=f.aid
	 WHERE f.rid IS NULL);


	


REM 6. Display the origin and destination of the flights having at least three departures with maximum distance covered.

SELECT orig_airport,dest_airport
FROM Flights,Routes,Fl_schedule
WHERE Flights.rid=Routes.routeid
	AND Flights.flightno=Fl_schedule.flno
	AND distance = (SELECT max(distance)
			FROM Routes)
GROUP BY orig_airport,dest_airport
HAVING COUNT(*)>=3;





REM 7. Display name and salary of pilot whose salary is more than the average salary of any pilots for each route other than flights originating from Madison airport.


SELECT DISTINCT e.ename,e.salary
FROM Employee e,Certified c,Aircraft a,Routes r,Flights f
WHERE (f.rid=r.routeid)
	AND (f.aid=a.aid)	
	AND (a.aid=c.aid)
	AND (c.eid=e.eid)
	AND r.routeid IN(SELECT routeid FROM routes
			WHERE orig_airport !='Madison')
	AND e.salary >(SELECT avg(salary)
			FROM employee e INNER JOIN certified c ON (e.eid=c.eid));





REM 8. Display the flight number, aircraft type, source and destination airport of the aircraft having maximum number of flights to Honolulu.

SELECT f.flightNo,a.type,r.orig_airport,r.dest_airport
FROM flights f, aircraft a, routes r
WHERE f.rID = r.routeID AND f.aid = a.aid
AND f.flightNo = ANY(SELECT f.flightNo 
		 	FROM routes r, flights f 
			WHERE r.dest_airport = 'Honolulu' AND r.routeID = f.rID
			GROUP BY f.flightNo 
			HAVING COUNT(*) >= ALL (SELECT COUNT(*) 
						 FROM flights f 
						 GROUP BY f.flightNo));
									




REM 9. Display the pilot(s) who are certified exclusively to pilot all aircraft in a type.

SELECT DISTINCT(eid),type,count(*)
FROM certified c,aircraft a
WHERE c.eid in(SELECT c1.eid 
		FROM certified c1,aircraft a1	
		WHERE c1.aid=a1.aid
		GROUP BY c1.eid
		HAVING COUNT(DISTINCT type)=1)
				AND c.aid=a.aid
				GROUP BY c.eid,a.type
				HAVING COUNT(*)=(SELECT COUNT(*) 
						  FROM aircraft a2
						  WHERE a2.type=a.type);	
			
			



REM 10. Name the employee(s) who is earning the maximum salary among the airport having maximum number of departures 

SELECT e.ename
FROM employee e
WHERE e.salary =(SELECT MAX(e.salary)
	   	  FROM employee e, certified c
		  WHERE	e.eid = c.eid
		  AND c.aid IN (SELECT f.aid FROM flights f, routes r
				WHERE f.rID = r.routeID
				AND r.orig_airport =(SELECT orig_airport 
						     FROM (SELECT r.orig_airport, COUNT(fl.departs)
							   FROM routes r, flights f, fl_schedule fl
						           WHERE r.routeID = f.rID AND fl.flno = f.flightNo
							   GROUP BY r.orig_airport
							   ORDER BY COUNT(fl.departs) DESC) 
						     WHERE rownum = 1)));	






REM 11. Display the departure chart as follows: flight number, departure(date,airport,time), destination airport, arrival time, aircraft name for the flights from New York airport during 15 to 19th April 2005. Make sure that the route contains at least two flights in the above specified condition

SELECT f1.flightNo,fs1.departs,fs1.dtime,fs1.atime,r1.orig_airport,r1.dest_airport,a1.aname
FROM flights f1,fl_schedule fs1,routes r1,aircraft a1
WHERE fs1.flno=f1.flightNo
	AND f1.rid=r1.routeID
	AND f1.aid=a1.aid
	AND r1.orig_airport='New York'
	AND fs1.departs between '15-apr-05' and '19-apr-05'
	AND exists(SELECT r.routeID from routes r,aircraft a,flights f,fl_schedule fs
			WHERE fs.flno=f.flightNo and f.rid=r.routeID
			AND f.aid=a.aid and r1.routeID=r.routeID
			GROUP BY (r.routeID)
			HAVING count(*)>=2)
ORDER BY fs1.atime DESC;





REM 12. A customer wants to travel from Madison to New York with no more than two changes of flight. List the flight numbers from Madison if the customer wants to arrive in New York by 6.50 p.m

SELECT flightno
FROM flights
WHERE flightno IN(SELECT f0.flightno
		FROM ((fl_schedule fl0 INNER JOIN flights f0 ON (fl0.flno=f0.flightno)) INNER JOIN routes r0 ON (f0.rid=r0.routeid))
		WHERE (r0.orig_airport='Madison') AND 
			(r0.dest_airport='New York') AND
			(fl0.atime<=1850))
		UNION
		(SELECT f0.flightno
		FROM ((fl_schedule fl0 INNER JOIN flights f0 ON (fl0.flno=f0.flightno)) INNER JOIN routes r0 ON (f0.rid=r0.routeid)),
			((fl_schedule fl1 INNER JOIN flights f1 ON (fl1.flno=f1.flightno)) INNER JOIN routes r1 ON (f1.rid=r1.routeid))
		WHERE (r0.dest_airport=r1.orig_airport) AND
			(r0.orig_airport='Madison') AND 
			(fl0.arrives<=fl1.departs) AND
			(r1.orig_airport<>'New York') AND
			(r1.dest_airport='New York') AND
			(fl1.atime<1850));
	





REM 13. Display the id and name of employee(s) who are not pilots.

SELECT	eid,ename	
FROM ((SELECT * 
       FROM employee) 
       MINUS
       (SELECT e.* 
	FROM 	employee e, certified c WHERE e.eid = c.eid));






REM 14. Display the id and name of employee(s) who pilots the aircraft from Los Angels and Detroit airport.


SELECT e.eid,e.ename
FROM employee e 
WHERE e.eid IN ((SELECT	e.eid	
		 FROM employee e, certified c, flights f, routes r
		 WHERE e.eid = c.eid AND f.aid = c.aid	AND	r.routeID = f.rID
				AND r.orig_airport = 'Los Angeles')	
				INTERSECT
				(SELECT	e.eid
				 FROM employee e, certified c, flights f, routes r
				 WHERE e.eid = c.eid AND f.aid = c.aid AND r.routeID = f.rID
				 AND r.orig_airport='Detroit'));




