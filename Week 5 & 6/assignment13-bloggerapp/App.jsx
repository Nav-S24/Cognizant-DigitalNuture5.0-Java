import React from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

const book = { title: 'Atomic Habits', author: 'James Clear' };
const blog = { title: 'Understanding React Hooks', author: 'Jane Doe' };
const course = { name: 'ReactJS Full Stack', status: 'ongoing' };

const App = () => {
  // Conditional rendering technique 5: element variable
  let heading;
  if (book && blog && course) {
    heading = <h1>Blogger App - All Content Available</h1>;
  } else {
    heading = <h1>Blogger App</h1>;
  }

  return (
    <div>
      {heading}
      <BookDetails book={book} />
      <hr />
      <BlogDetails blog={blog} />
      <hr />
      <CourseDetails course={course} />
    </div>
  );
};

export default App;
