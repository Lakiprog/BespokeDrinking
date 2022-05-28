import React, { Fragment } from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Registration from './Containers/Registration/Registration';
import "bootstrap/dist/css/bootstrap.min.css";
import Restaurants from './Containers/Restaurants/Restaurants';
import Questionnaire from './Containers/Questionnaire/Questionnaire';

function App() {
  return (
    <div className="App">
      <Router>
				<Fragment>
					<Routes>
            <Route path="/" element={<Registration />} />
            <Route path="/restaurants" element={<Restaurants/>} />
            <Route path="/questionnaire" element={<Questionnaire/>} />
						{/* <Route path="/login" element={<Login />} />
            <Route path="/create-question" element={<QuestionCreation/>} />
            <Route path="/recommendations" element={<Recommendations/>} /> */}
          </Routes>
        </Fragment>
      </Router>
    </div>
  );
}

export default App;
