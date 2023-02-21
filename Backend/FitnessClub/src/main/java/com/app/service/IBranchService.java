package com.app.service;

import com.app.pojos.Branch;

public interface IBranchService
{

	Branch addBranch(Branch m);

	Branch cascade(long id);

	Branch deleteBranch(long id);

}
