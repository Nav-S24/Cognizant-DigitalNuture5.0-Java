import React from 'react';

const BlogDetails = ({ blog }) => {
  // Conditional rendering technique 2: ternary operator
  return (
    <div>
      <h3>Blog Details</h3>
      {blog ? (
        <div>
          <p>Title: {blog.title}</p>
          <p>Author: {blog.author}</p>
        </div>
      ) : (
        <p>No blog post available.</p>
      )}
    </div>
  );
};

export default BlogDetails;
