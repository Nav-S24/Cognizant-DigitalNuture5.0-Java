import React from 'react';

const BookDetails = ({ book }) => {
  // Conditional rendering technique 1: if / else with an early return
  if (!book) {
    return <p>No book selected.</p>;
  }

  return (
    <div>
      <h3>Book Details</h3>
      <p>Title: {book.title}</p>
      <p>Author: {book.author}</p>
    </div>
  );
};

export default BookDetails;
