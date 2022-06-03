import { useState } from "react";
import { Link } from "react-router-dom";
import { Collapse, Nav, Navbar, NavbarToggler, NavItem } from "reactstrap";
import * as authService from "../Auth/AuthService";

const UserNavbar = () => {
	const [collapsed, setCollapsed] = useState(true);
	const toggleNavbar = () => setCollapsed(!collapsed);

	const logout = () => {
		authService.removeToken();
	};

	return (
		<div className="nav-bar">
			<Navbar color="dark" light expand="md">
				<Link to="/questionnaire">Questionnaire</Link>
				<NavbarToggler onClick={toggleNavbar} className="mr-2" />
				<Collapse isOpen={!collapsed} navbar>
					<Nav navbar>
						{/* <NavItem>
							<Link to="/recommendations">Recommendations</Link>
						</NavItem> */}
						<NavItem>
							<Link to="/drinks">Drinks</Link>
						</NavItem>
						<NavItem>
							<Link to="/restaurants">Restaurants</Link>
						</NavItem>
						<NavItem>
							<Link to="/" onClick={logout}>
								Logout
							</Link>
						</NavItem>
					</Nav>
				</Collapse>
			</Navbar>
		</div>
	);
};

export default UserNavbar;
