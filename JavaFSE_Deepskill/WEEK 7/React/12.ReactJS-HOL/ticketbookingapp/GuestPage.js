import React from 'react';
import FlightList from './FlightList';

function GuestPage() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>Please log in to book tickets.</p>
      <FlightList />
    </div>
  );
}

export default GuestPage;
