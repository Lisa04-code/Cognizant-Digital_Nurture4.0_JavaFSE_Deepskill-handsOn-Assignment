import React from 'react';

function FlightList({ canBook = false }) {
  const flights = [
    { id: 1, from: "Delhi", to: "Mumbai", time: "10:00 AM" },
    { id: 2, from: "Kolkata", to: "Bangalore", time: "2:30 PM" },
    { id: 3, from: "Chennai", to: "Hyderabad", time: "6:00 PM" },
  ];

  return (
    <div>
      <h3>Available Flights</h3>
      <ul>
        {flights.map((flight) => (
          <li key={flight.id}>
            {flight.from} → {flight.to} at {flight.time}
            {canBook && <button style={{ marginLeft: '10px' }}>Book</button>}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FlightList;
