import { useState } from "react";
import { Link } from "react-router-dom";
import { Collapse, Nav, Navbar, NavbarToggler, NavItem } from "reactstrap";

const UnauthenticatedNavbar = () => {
	const [collapsed, setCollapsed] = useState(true);
	const toggleNavbar = () => setCollapsed(!collapsed);

	return (
		<div className="nav-bar">
			<Navbar color="dark" light expand="md">
				<Link to="/">Registration</Link>
				<NavbarToggler onClick={toggleNavbar} className="mr-2" />
				<Collapse isOpen={!collapsed} navbar>
					<Nav navbar>
						<NavItem>
							<Link to="/restaurants">Restaurants</Link>
						</NavItem>
						<NavItem>
							<Link to="/login">Login</Link>
						</NavItem>
					</Nav>
				</Collapse>
			</Navbar>
		</div>
	);
};

export default UnauthenticatedNavbar;