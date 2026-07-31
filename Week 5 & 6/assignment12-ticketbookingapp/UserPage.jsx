import React from 'react';

const flights = [
  { id: 1, airline: 'IndiGo', from: 'Pune', to: 'Delhi', fare: 4500 },
  { id: 2, airline: 'Air India', from: 'Mumbai', to: 'Bangalore', fare: 5200 },
  { id: 3, airline: 'Vistara', from: 'Chennai', to: 'Hyderabad', fare: 3800 },
];

const UserPage = () => (
  <div>
    <h2>Book Your Ticket</h2>
    <p>Welcome back! You can now book tickets on the flights below.</p>
    <ul>
      {flights.map((flight) => (
        <li key={flight.id}>
          {flight.airline}: {flight.from} to {flight.to} - Rs. {flight.fare}{' '}
          <button onClick={() => alert(`Ticket booked on ${flight.airline}`)}>Book</button>
        </li>
      ))}
    </ul>
  </div>
);

export default UserPage;
