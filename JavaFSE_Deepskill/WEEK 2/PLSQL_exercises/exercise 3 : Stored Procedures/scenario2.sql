DECLARE
    
    TYPE t_employee IS RECORD (
        employee_id NUMBER,
        first_name VARCHAR2(50),
        last_name VARCHAR2(50),
        department VARCHAR2(50),
        salary NUMBER(10,2),
        bonus NUMBER(10,2)
    );
    
    TYPE t_employees IS TABLE OF t_employee;
    
    
    v_employees t_employees := t_employees(
        t_employee(1, 'Ronnie', 'Pramanick', 'IT', 60000, 0),
        t_employee(2, 'Lisa', 'Smith', 'HR', 55000, 0)
    );
    
    
    p_department VARCHAR2(20) := 'IT';
    p_bonus_percent NUMBER := 10;
    v_updated_rows NUMBER := 0;
BEGIN
    
    IF p_bonus_percent < 0 OR p_bonus_percent > 100 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Bonus must be 0-100%');
        RETURN;
    END IF;
    
    
    FOR i IN 1..v_employees.COUNT LOOP
        IF v_employees(i).department = p_department THEN
            v_employees(i).bonus := v_employees(i).salary * (p_bonus_percent/100);
            v_employees(i).salary := v_employees(i).salary * (1 + p_bonus_percent/100);
            v_updated_rows := v_updated_rows + 1;
            
            DBMS_OUTPUT.PUT_LINE(
                v_employees(i).first_name || ' ' || v_employees(i).last_name || 
                ' new salary: ' || v_employees(i).salary || 
                ' (bonus: ' || v_employees(i).bonus || ')'
            );
        END IF;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Added ' || p_bonus_percent || '% bonus to ' || 
                        v_updated_rows || ' employees in ' || p_department);
END;
/