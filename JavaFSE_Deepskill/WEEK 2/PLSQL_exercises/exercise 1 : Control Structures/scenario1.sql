create table customers(
    customer_id int primary key,
    first_name varchar2(50),
    last_name varchar2(50),
    birth_date date,
    loan_interest_rate number(5,2),
    last_updated date
);

insert into customers values(1,'Shanaya','Singhania','16-JAN-1950',5.25,null);
insert into customers values(2,'Siddharth','Kumar','30-MAR-1990',4.75,null);
insert into customers values(3,'Varun','Sachdeva','12-NOV-1962',6.00,null);

select*from customers;

DECLARE
    CURSOR c_customers IS
        SELECT customer_id, first_name, last_name, birth_date, loan_interest_rate
        FROM customers
        WHERE loan_interest_rate IS NOT NULL;
    
    v_age NUMBER;
    v_discount_rate CONSTANT NUMBER := 1.0; -- 1% discount
BEGIN
    FOR r_customer IN c_customers LOOP
        
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_customer.birth_date) / 12);
        
        
        IF v_age > 60 THEN
            UPDATE customers
            SET 
                loan_interest_rate = loan_interest_rate - v_discount_rate,
                last_updated = SYSDATE
            WHERE customer_id = r_customer.customer_id;
            
            DBMS_OUTPUT.PUT_LINE(
                'Applied 1% discount to ' || 
                r_customer.first_name || ' ' || r_customer.last_name || 
                ' (New Rate: ' || (r_customer.loan_interest_rate - v_discount_rate) || '%)'
            );
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior discount processing complete.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;
/