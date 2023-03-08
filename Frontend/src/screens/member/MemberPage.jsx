import React from "react";
import { Link } from "react-router-dom";
import Logout from '../../screens/common/Logout';
import {useSelector} from 'react-redux';
import {useHistory} from 'react-router-dom';
//import './MemberPage.css';
//import UserProfile from './UserProfile';
//import Card from './Card';

const MemberPage = () => {
  
  

  const history=useHistory();
  const isSignin = useSelector((state) => state.isSignin);

  sessionStorage.setItem('myData', isSignin.user.id);

  console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  console.log(isSignin.user);

  if(isSignin.status === false){
    alert('please signin first!!') 
    history.push('/login')
  }
  
  return (
    <div className="privacydiv">
      <Logout />
      <div align="center" className="admin-page">
        MemberPage
      </div>
      
      <br></br><br></br>

        <button className="block"
        onClick={()=>{history.push('/purchasepage')}}>Purchase Membership
        </button>

        <button className="block"
        onClick={()=>{history.push('/addreport')}}>Add Report / View Report
        </button>

      <Link to="/profilemember"><a className="block" href=" ">          Profile        </a>      </Link>

    </div>
  );
};
export default MemberPage;
