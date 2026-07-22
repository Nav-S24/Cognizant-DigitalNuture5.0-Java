import React from 'react';
import '../Stylesheets/mystyle.css';

// Functional component that accepts Name, School, Total and Goal as props
// and calculates + displays the average score of a student.
function CalculateScore(props) {
  const { name, school, total, goal, subjects } = props;

  // Average = total marks scored / number of subjects
  const average = (total / subjects).toFixed(2);
  const achievedGoal = average >= goal;

  return (
    <div className="score-card">
      <h2>Student Score Report</h2>
      <p><span className="label">Name:</span> {name}</p>
      <p><span className="label">School:</span> {school}</p>
      <p><span className="label">Total Marks:</span> {total}</p>
      <p><span className="label">Average Score:</span> {average}</p>
      <p><span className="label">Goal:</span> {goal}</p>
      <p className={achievedGoal ? 'success' : 'fail'}>
        {achievedGoal
          ? 'Congratulations! Goal achieved.'
          : 'Goal not achieved yet. Keep working hard!'}
      </p>
    </div>
  );
}

export default CalculateScore;
