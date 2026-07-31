import React from 'react';

// Conditional rendering technique 3: switch-case
const getStatusMessage = (status) => {
  switch (status) {
    case 'ongoing':
      return 'This course is currently ongoing.';
    case 'completed':
      return 'This course has been completed.';
    case 'upcoming':
      return 'This course will start soon.';
    default:
      return 'Status unknown.';
  }
};

const CourseDetails = ({ course }) => {
  return (
    <div>
      <h3>Course Details</h3>
      {/* Conditional rendering technique 4: && operator (short-circuit) */}
      {course && (
        <div>
          <p>Name: {course.name}</p>
          <p>{getStatusMessage(course.status)}</p>
        </div>
      )}
      {!course && <p>No course selected.</p>}
    </div>
  );
};

export default CourseDetails;
