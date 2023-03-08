import React, { useState, useEffect } from "react";
//import {Link} from 'react-router-dom';
import { useParams } from "react-router-dom";
import axios from "axios";
import Logout from '../../screens/common/Logout';
import {useHistory} from 'react-router-dom';
import {Link} from 'react-router-dom';
import { useSelector } from "react-redux";





const User = () => {

  
const user = useSelector((state) => state.isSignin);
const [firstName, setFname] = useState("");
  const [lastName, setLname] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phone, setPhone] = useState("");
  //const [role, setRole] = useState("");
  const [userBranchId, setUserBranchId] = useState("");
  const history = useHistory();



  console.log(user);
  const { id } = useParams(); 
  useEffect(() => {
    setFname(user.user.firstName);
    setLname(user.user.lastName);
    setEmail(user.user.email);
    setPassword(user.user.password);
    setPhone(user.user.phoneNo);
    // setRole(user.user.role);
    //setUserBranchId(user.user.branch.branchName);


    
  },[]);
  
  console.log(user.user.firstName);
  return (
    <div className="privacydiv2">
      <Logout/>
    <div className="container py-4">
      

      <div>
      
      <h1 className="display-6">
       
        Profile
        
        
        </h1>
      
      <hr />
      <ul className="list-group w-60">
      {/* <li className="list-group-item">BranchId: {userBranchId}</li> */}
        <li className="list-group-item">Name: {firstName} {lastName}</li>
        
        <li className="list-group-item">Email: {email}</li>
        <li className="list-group-item">Password: {password}</li>
        <li className="list-group-item">Phone: {phone}</li>
      </ul>
      </div>
      <div>
        <hr/>
        {/* <button type="button" class="btn btn-light" onClick={()=>{
                                 history.push('/updatebatch', {user:user})
                                }}>
                                           Edit
                                        </button> */}
                                        <Link to="/memberpage">
               &nbsp;&nbsp; <button className="btn btn-primary">Back</button>
            </Link>
      </div>
    </div>

    <hr/>
        <hr/>
        <hr/>
    
    </div>
  );
};

export default User;