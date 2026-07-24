import React from 'react';

// Single office object with Name, Rent, Address
const office = {
  name: 'Cognizant Business Park',
  rent: 55000,
  address: 'Pune, Maharashtra',
  image: '/office.jpg',
};

// List of office objects to loop through
const officeSpaceList = [
  { name: 'Cognizant Business Park', rent: 55000, address: 'Pune, Maharashtra' },
  { name: 'Tech Hub Tower', rent: 72000, address: 'Bangalore, Karnataka' },
  { name: 'Business Bay Center', rent: 48000, address: 'Hyderabad, Telangana' },
  { name: 'Skyline Corporate Center', rent: 65000, address: 'Mumbai, Maharashtra' },
];

const App = () => {
  return (
    <div>
      {/* Heading element created with JSX */}
      <h1>Office Space Rental</h1>

      {/* Attribute usage: image of the office space */}
      <img src={office.image} alt="Office Space" width="400" />

      <h2>Featured Office</h2>
      <p>Name: {office.name}</p>
      <p>Address: {office.address}</p>
      {/* JavaScript expression + inline CSS in JSX: red if below 60000, green if above */}
      <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
        Rent: {office.rent}
      </p>

      <h2>All Office Spaces</h2>
      <ul>
        {officeSpaceList.map((item, index) => (
          <li key={index}>
            {item.name} - {item.address} -{' '}
            <span style={{ color: item.rent < 60000 ? 'red' : 'green' }}>
              {item.rent}
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;

/*
Equivalent using React.createElement() instead of JSX, for reference
(this is what the JSX above compiles down to for a single row):

React.createElement(
  'p',
  { style: { color: office.rent < 60000 ? 'red' : 'green' } },
  'Rent: ', office.rent
);
*/
