create table customers2 (
    customer_id int primary key,
    first_name varchar2(50),
    last_name varchar2(50),
    account_balance number(12,2),
    is_vip char(1) default 'N' check(is_vip in ('Y', 'N'))
);
insert into customers2 values (1, 'Luke', 'Wilson', 8000.00, 'N');
insert into customers2 values (2, 'Louis', 'Patridge', 25000.00, 'N');
insert into customers2 values (3, 'Calvin', 'Harris', 30000.00, 'N');

select*from customers2;
DECLARE
    
    CURSOR c_customers2 IS
        SELECT customer_id, first_name, last_name, account_balance
        FROM customers2
        WHERE is_vip = 'N' AND account_balance > 10000;
    
    
    v_vip_count NUMBER := 0;
BEGIN
   
    FOR r_customer2 IN c_customers2 LOOP
       
        UPDATE customers2
        SET is_vip = 'Y'
        WHERE customer_id = r_customer2.customer_id;
        
        
        v_vip_count := v_vip_count + 1;
        
        
        DBMS_OUTPUT.PUT_LINE(
            'Promoted: ' || r_customer2.first_name || ' ' || 
            r_customer2.last_name || ' (ID: ' || 
            r_customer2.customer_id || ')'
        );
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Total VIPs promoted: ' || v_vip_count);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/