import React from 'react';

const flights = [
  { id: 1, airline: 'IndiGo', from: 'Pune', to: 'Delhi', fare: 4500 },
  { id: 2, airline: 'Air India', from: 'Mumbai', to: 'Bangalore', fare: 5200 },
  { id: 3, airline: 'Vistara', from: 'Chennai', to: 'Hyderabad', fare: 3800 },
];

const GuestPage = () => (
  <div>
    <h2>Available Flights</h2>
    <ul>
      {flights.map((flight) => (
        <li key={flight.id}>
          {flight.airline}: {flight.from} to {flight.to} - Rs. {flight.fare}
        </li>
      ))}
    </ul>
    <p>Please login to book a ticket.</p>
  </div>
);

export default GuestPage;
