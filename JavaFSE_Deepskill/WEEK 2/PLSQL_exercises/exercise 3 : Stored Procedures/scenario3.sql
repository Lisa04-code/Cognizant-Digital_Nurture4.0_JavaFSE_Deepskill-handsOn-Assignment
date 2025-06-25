DECLARE
   
    TYPE t_account IS RECORD (
        account_id NUMBER,
        customer_id NUMBER,
        balance NUMBER(12,2),
        last_transaction DATE
    );
    
    TYPE t_accounts IS TABLE OF t_account;
    
    
    v_accounts t_accounts := t_accounts(
        t_account(1001, 1, 9000.00, NULL),
        t_account(1002, 2, 1000.00, NULL)
    );
    
    
    p_from_account NUMBER := 1001;
    p_to_account NUMBER := 1002;
    p_amount NUMBER := 1000;
    
    v_source_idx NUMBER;
    v_target_idx NUMBER;
    v_source_found BOOLEAN := FALSE;
    v_target_found BOOLEAN := FALSE;
BEGIN
    
    FOR i IN 1..v_accounts.COUNT LOOP
        IF v_accounts(i).account_id = p_from_account THEN
            v_source_idx := i;
            v_source_found := TRUE;
        ELSIF v_accounts(i).account_id = p_to_account THEN
            v_target_idx := i;
            v_target_found := TRUE;
        END IF;
    END LOOP;
    
    
    IF NOT v_source_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Source account not found');
        RETURN;
    ELSIF NOT v_target_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Target account not found');
        RETURN;
    ELSIF v_accounts(v_source_idx).balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds');
        RETURN;
    END IF;
    
    v_accounts(v_source_idx).balance := v_accounts(v_source_idx).balance - p_amount;
    v_accounts(v_target_idx).balance := v_accounts(v_target_idx).balance + p_amount;
    v_accounts(v_source_idx).last_transaction := SYSDATE;
    v_accounts(v_target_idx).last_transaction := SYSDATE;
    
    DBMS_OUTPUT.PUT_LINE(
        'Successfully transferred $' || p_amount || 
        ' from account ' || p_from_account || 
        ' to ' || p_to_account
    );
    DBMS_OUTPUT.PUT_LINE(
        'New balances - Source: $' || v_accounts(v_source_idx).balance || 
        ', Target: $' || v_accounts(v_target_idx).balance
    );
END;
/