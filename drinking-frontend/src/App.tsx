import { Fragment } from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Registration from "./Containers/Registration/Registration";
import "bootstrap/dist/css/bootstrap.min.css";
import Restaurants from "./Containers/Restaurants/Restaurants";
import Questionnaire from "./Containers/Questionnaire/Questionnaire";
import Login from "./Auth/Login";
import ProtectedRoute from "./Auth/ProtectedRoute";
import Drinks from "./Containers/Drinks/Drinks";
import UpdatePreference from "./Containers/UpdatePreference/UpdatePreference";
import CreateQuestion from "./Containers/CreateQuestion/CreateQuestion";

function App() {
	return (
		<div className="App">
			<Router>
				<Fragment>
					<Routes>
						<Route path="/" element={<Login />} />
						<Route path="/registration" element={<Registration />} />
						<Route
							path="/restaurants"
							element={<ProtectedRoute roles={["ROLE_ADMIN", "ROLE_USER"]} />}
						>
							<Route path="/restaurants" element={<Restaurants />} />
						</Route>
						<Route
							path="/drinks"
							element={<ProtectedRoute roles={["ROLE_ADMIN", "ROLE_USER"]} />}
						>
							<Route path="/drinks" element={<Drinks />} />
						</Route>
						<Route
							path="/questionnaire"
							element={<ProtectedRoute roles={["ROLE_USER"]} />}
						>
							<Route path="/questionnaire" element={<Questionnaire />} />
						</Route>
						<Route
							path="/additionalQuestions"
							element={<ProtectedRoute roles={["ROLE_USER"]} />}
						>
							<Route
								path="/additionalQuestions"
								element={<UpdatePreference />}
							/>
						</Route>
						<Route
							path="/createQuestion"
							element={<ProtectedRoute roles={["ROLE_ADMIN"]} />}
						>
							<Route path="/createQuestion" element={<CreateQuestion />} />
						</Route>
						{/* <Route path="/create-question" element={<QuestionCreation/>} />
            <Route path="/recommendations" element={<Recommendations/>} /> */}
					</Routes>
				</Fragment>
			</Router>
		</div>
	);
}

export default App;
