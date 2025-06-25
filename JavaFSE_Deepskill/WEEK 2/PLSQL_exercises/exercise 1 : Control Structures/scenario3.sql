create table customers3 (
    customer_id int primary key,
    first_name varchar2(50),
    last_name varchar2(50),
    email varchar2(100)
);

create table loans (
    loan_id int primary key,
    customer_id int references customers3(customer_id),
    due_date date,
    status varchar2(10) check (status in ('ACTIVE', 'PAID', 'DEFAULTED'))
);

insert into customers3 values (1, 'Samuel', 'Gomes', 'samuelgomes@gmail.com');
insert into customers3 values (2, 'Ronnie', 'Pramanick', 'ronniep97@gmail.com');

insert into loans values (101, 1, SYSDATE + 15, 'ACTIVE');
insert into loans values (102, 2, SYSDATE + 60, 'ACTIVE');

select*from customers3;
select*from loans;

DECLARE
    CURSOR c_loans_due IS
        SELECT 
            l.loan_id,
            c.first_name,
            c.last_name,
            c.email,
            l.due_date
        FROM loans l
        JOIN customers3 c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
        AND l.status = 'ACTIVE';
    
    v_days_remaining NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== LOAN DUE REMINDERS ===');
    
    FOR r_loan IN c_loans_due LOOP
        v_days_remaining := r_loan.due_date - SYSDATE;
        
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan #' || r_loan.loan_id || 
            ' (Due in ' || v_days_remaining || ' days)' || CHR(10) ||
            'Customer: ' || r_loan.first_name || ' ' || r_loan.last_name || CHR(10) ||
            'Email: ' || r_loan.email || CHR(10) ||
            '--------------------------------'
        );
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Reminder generation completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;
/