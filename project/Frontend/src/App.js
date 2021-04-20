import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import './App.css';
import Navbar from './Components/Navbar'
import Dashboard from './Pages/Dashboard'
import ViewInventory from './Pages/ViewInventory'
import RestockInventory from './Pages/RestockInventory'
import Statistics from './Pages/Statistics'

export default function App() {
  return (
    <>
    <Router>
      <Navbar />
      <Switch>
        <Route path='/' exact component={Dashboard} />
        <Route path='/view-inventory' component={ViewInventory} />
        <Route path='/restock-inventory' component={RestockInventory} />
        <Route path='/statistics' component={Statistics} />
      </Switch>
    </Router>
    </>
  );
}

