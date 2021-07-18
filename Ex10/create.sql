REM Drop table
DROP TABLE Emp_Payroll;

REM Create table
CREATE TABLE Emp_Payroll(
	eid number(5) CONSTRAINT id_pk PRIMARY KEY,
	ename varchar2(20),
	dob date,
	sex varchar2(10),
	designation varchar2(20),
	basic number(10,2),
	da number(10,2),
	hra number(10,2),
	pf number(10,2),
	mc number(10,2),
	gross number(10,2),
	tot_deduc number(10,2),
	net_pay number(10,2));
	
	
REM Procedure
CREATE OR REPLACE PROCEDURE calc
(peid Emp_Payroll.eid%type, pbasic Emp_Payroll.basic%type) IS
    pda Emp_Payroll.da%type;
    phra Emp_Payroll.hra%type;
    ppf Emp_Payroll.pf%type;
    pmc Emp_Payroll.mc%type;
    pgross Emp_Payroll.gross%type;
    ptot_deduc Emp_Payroll.tot_deduc%type;
    pnet_pay Emp_Payroll.net_pay%type;
BEGIN
    pda:=0.60*pbasic;
    phra:=0.11*pbasic;
    ppf:=0.04*pbasic;
    pmc:=0.03*pbasic;
    pgross:=pbasic+pda+phra;
    ptot_deduc:=ppf+pmc;
    pnet_pay:=pgross-ptot_deduc;
    UPDATE Emp_Payroll 
	SET da = pda, hra = phra, pf = ppf, mc = pmc, gross = pgross, tot_deduc = ptot_deduc, net_pay = pnet_pay
    WHERE eid = peid;
END;
/
commit;



