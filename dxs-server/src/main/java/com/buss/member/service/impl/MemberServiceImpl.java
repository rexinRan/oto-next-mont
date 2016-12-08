package com.buss.member.service.impl;

import org.jweb.core.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.member.service.IMemberService;

/**
 * 会员相关Service
 * 
 * @author 荆志宝
 *
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl extends CommonServiceImpl implements IMemberService {

}
