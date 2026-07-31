import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    // Initialize the component state with an empty list of posts
    this.state = {
      posts: [],
      hasError: false,
      errorMessage: ''
    };
  }

  // Fetch posts from the API and store them (as Post instances) in state
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const posts = data
          .slice(0, 10)
          .map((item) => new Post(item.id, item.title, item.body));
        this.setState({ posts });
      })
      .catch((error) => {
        // Trigger the error boundary logic manually if the fetch itself fails
        this.setState({ hasError: true, errorMessage: error.message });
      });
  };

  // Lifecycle hook: called once, right after the component mounts to the DOM
  componentDidMount() {
    this.loadPosts();
  }

  // Lifecycle hook: catches errors thrown anywhere below this component
  // in the tree during rendering, in lifecycle methods, and in constructors
  componentDidCatch(error, info) {
    this.setState({ hasError: true, errorMessage: error.message });
    // eslint-disable-next-line no-alert
    alert(`Something went wrong while loading posts: ${error.message}`);
    console.error('componentDidCatch:', error, info);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong while loading the posts.</h2>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
