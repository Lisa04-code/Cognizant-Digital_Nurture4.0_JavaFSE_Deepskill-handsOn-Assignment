import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [type, setType] = useState('book');
  const isLoggedIn = true;
  const userRole = 'student';

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>📖 Blogger App</h1>

      {/* Buttons to switch views */}
      <div>
        <button onClick={() => setType('book')}>Show Book</button>
        <button onClick={() => setType('blog')}>Show Blog</button>
        <button onClick={() => setType('course')}>Show Course</button>
      </div>

      <hr />

      {/* Method 1: If-Else using Ternary */}
      <h3>Method 1: Ternary Operator</h3>
      {type === 'book' ? <BookDetails /> : type === 'blog' ? <BlogDetails /> : <CourseDetails />}

      <hr />

      {/* Method 2: Logical AND (&&) */}
      <h3>Method 2: Logical AND (&&)</h3>
      {type === 'book' && <BookDetails />}
      {type === 'blog' && <BlogDetails />}
      {type === 'course' && <CourseDetails />}

      <hr />

      {/* Method 3: Using Variable to Hold JSX */}
      <h3>Method 3: Variable Assignment</h3>
      {(() => {
        let content;
        if (type === 'book') content = <BookDetails />;
        else if (type === 'blog') content = <BlogDetails />;
        else content = <CourseDetails />;
        return content;
      })()}

      <hr />

      {/* Method 4: Using Switch Statement */}
      <h3>Method 4: Switch Case</h3>
      {
        (() => {
          switch (type) {
            case 'book': return <BookDetails />;
            case 'blog': return <BlogDetails />;
            case 'course': return <CourseDetails />;
            default: return <p>No Component Selected</p>;
          }
        })()
      }

      <hr />

      {/* Method 5: Conditional Rendering Based on Auth Status */}
      <h3>Method 5: Login Based</h3>
      {isLoggedIn ? <p>Welcome, logged-in user!</p> : <p>Please log in to continue.</p>}

      {/* Method 6: Render Based on User Role */}
      <h3>Method 6: Role Based</h3>
      {
        userRole === 'student' ? <CourseDetails /> :
        userRole === 'blogger' ? <BlogDetails /> :
        <BookDetails />
      }

    </div>
  );
}

export default App;

