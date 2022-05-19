import { useState } from "react";
import { Link } from "react-router-dom";
import { Collapse, Nav, Navbar, NavbarToggler, NavItem } from "reactstrap";

const AdminNavbar = () => {
	const [collapsed, setCollapsed] = useState(true);
	const toggleNavbar = () => setCollapsed(!collapsed);

	// const logout = () => {
	// 	authService.removeToken();
	// };

	return (
		<div className="nav-bar">
			<Navbar color="dark" light expand="md">
				<Link to="/restaurants">Restaurants</Link>
				<NavbarToggler onClick={toggleNavbar} className="mr-2" />
				<Collapse isOpen={!collapsed} navbar>
					<Nav navbar>
						<NavItem>
							<Link to="/create-question">Create Question</Link>
						</NavItem>
						<NavItem>
							<Link to="/login">Logout</Link>
						</NavItem>
					</Nav>
				</Collapse>
			</Navbar>
		</div>
	);
};

export default AdminNavbar;