import React from 'react'
import { Link } from "react-router-dom";
import Logout from '../../screens/common/Logout';
import {useSelector} from 'react-redux';
import {useHistory} from 'react-router-dom';

const  LocalAdminPage=()=> {


  const history=useHistory();
  const isSignin = useSelector((state) => state.isSignin);

  console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  console.log(isSignin.user);
  // console.log("yyyyy"+isSignin.user.branch.id);
  if(isSignin.status === false){
    alert('please signin first!!')
    history.push('/login')
  }
  return (
    <div className="privacydiv">
        <Logout/>
        <div align="center" className="admin-page">
      Local Admin Page
      </div>
      <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>

        
        {/* <Link to="/mymembers"> <a className="block" href=" ">Members</a> </Link>

        <Link to="/mytrainers"> <a className="block" href=" ">Trainers</a> </Link> */}

        {/* <Link to="/mybranchpage"> */}
        <button className="block"
        onClick={()=>{history.push('/mybranchpage',{branchId:isSignin.user.branch.id})}}>Branch Page
        </button>
        {/* <a className="block" href="/mybranchpage">Branch Page</a>  */}
        {/* </Link> */}

        <Link to="/brancheslist"> <a className="block" href=" ">Branches</a> </Link>

        <Link to="/packageslist"> <a className="block" href=" ">Packages</a> </Link>

        {/* <Link to="/batches"> <a className="block" href=" ">Batches</a> </Link> */}

        <hr/>
        <hr/> 
        <hr/>
        
        {/* <div className="container py-4" align="right">
            <Link to="/logout"> <a className="btn btn-info" href=" "> Logout </a> </Link>
            </div> */}


    </div>
  )
}
export default LocalAdminPage