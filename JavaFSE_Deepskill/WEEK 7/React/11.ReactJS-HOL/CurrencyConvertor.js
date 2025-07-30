import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = () => {
    const amt = parseFloat(amount);

    if (currency.toLowerCase() === 'euro') {
      const converted = amt * 80; // Example: 1 Euro = 80 INR
      alert(`Converting to Euro Amount is ${converted}`);
    } else {
      alert("Please enter currency as 'Euro'");
    }
  };

  return (
    <div>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <label>Amount:</label>&nbsp;
      <input
        type="number"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      /><br /><br />
      <label>Currency:</label>&nbsp;
      <input
        type="text"
        value={currency}
        onChange={(e) => setCurrency(e.target.value)}
      /><br /><br />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default CurrencyConvertor;
