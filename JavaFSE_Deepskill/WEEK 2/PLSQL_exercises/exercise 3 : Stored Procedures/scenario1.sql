DECLARE
    
    TYPE t_account IS RECORD (
        account_id NUMBER,
        customer_id NUMBER,
        account_type VARCHAR2(20),
        balance NUMBER(12,2),
        last_interest_date DATE
    );
    
    TYPE t_accounts IS TABLE OF t_account;
    
    
    v_accounts t_accounts := t_accounts(
        t_account(101, 1, 'SAVINGS', 5000.00, NULL),
        t_account(102, 2, 'CHECKING', 3000.00, NULL)
    );
    
    v_interest_rate CONSTANT NUMBER := 0.01; -- 1%
    v_updated_rows NUMBER := 0;
BEGIN
   
    FOR i IN 1..v_accounts.COUNT LOOP
        IF v_accounts(i).account_type = 'SAVINGS' THEN
            v_accounts(i).balance := v_accounts(i).balance * (1 + v_interest_rate);
            v_accounts(i).last_interest_date := SYSDATE;
            v_updated_rows := v_updated_rows + 1;
            
            DBMS_OUTPUT.PUT_LINE(
                'Account ' || v_accounts(i).account_id || 
                ' new balance: ' || v_accounts(i).balance
            );
        END IF;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Applied 1% interest to ' || v_updated_rows || ' savings accounts');
END;
/