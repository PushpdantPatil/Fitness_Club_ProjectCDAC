package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Batch;
import com.app.pojos.Branch;
import com.app.repository.BatchRepository;
import com.app.repository.BranchRepository;

@Service
@Transactional
public class BatchServiceImpl implements IBatchService 
{

	@Autowired
	private BatchRepository bb;
	
	@Autowired
	private BranchRepository branch;

	@Override
	public Batch addNewBatch(Batch batch, long branchBranchId) 
	{
		Branch b = branch.findById(branchBranchId).get();
		b.getBatches().add(batch);
		batch.setBranch(b);
		Batch bat = bb.save(batch);
		return bat;
	}

	@Override
	public List<Batch> getAllBatches() 
	{
		return bb.findAll();
	}

	@Override
	public List<Batch> getBatchesByBranchId(long id) 
	{
		Branch b = branch.findById(id).get();
		return bb.findByBranch(b);
	}

	@Override
	public Batch updateBatch(Batch batch, long id) 
	{
		Batch b = bb.findById(id).get();
		b.setBatchTime(batch.getBatchTime());
		b.setBatchType(batch.getBatchType());
		b.setBranch(batch.getBranch());
		return bb.save(b);
	}

	@Override
	public String deleteBatch(long id)
	{
		Batch del=bb.findById(id).get();
		del.getBranch().getBatches().remove(del);
	    bb.delete(del);
	    return "Successfully deleted";
	}
	
	
	
	
	
	
}
