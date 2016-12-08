package com.buss.auth.service.impl;

import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm {
	/*
	 * @Autowired UserService userService;
	 * 
	 * @Autowired RoleService roleService;
	 * 
	 * @Autowired LoginLogService loginLogService;
	 */
	@Autowired
	private SysServiceI sysService;

	public MonitorRealm() {
		super();

	}

	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/* 这里编写授权代码 */
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();

		Object user = principals.getPrimaryPrincipal();
/*

		// 获取当前用户类型（前台用户、后台用户）
		if (user instanceof GeneralUserEntity) {
			// 控制台打印信息
			System.out.println("当前用户是前台用户登录！");
			GeneralUserEntity userEntity = (GeneralUserEntity) user;
			// 当前用户是前台用户
			List<UserAndRoleEntity> userAndRoleList = userEntity.getRoles();

			// 授权
			for (UserAndRoleEntity ur : userAndRoleList) {
				RoleEntity role = ur.getRole();
				roleNames.add(role.getCode());
				List<RoleAndFunctionEntity> roleAndFunList = role.getFunctions();
				for (RoleAndFunctionEntity rf : roleAndFunList) {
					FunctionEntity fun = rf.getFunction();
					permissions.add(fun.getValue());
				}
			}

		} else {
			// 用户是后台用户登录
			System.out.println("当前用户是后台用户登录！");
			// 后台用户
			AdminEntity adminEntity = (AdminEntity) user;
			if ("admin".equals(adminEntity.getUsername())) {
				// 当前后台用户是超级管理员，获得所有权限
				List<AuthFunctionEntity> list = this.sysService.getList(AuthFunctionEntity.class);
				for (AuthFunctionEntity authFunctionEntity : list) {
					permissions.add(authFunctionEntity.getCode());
				}
			} else {
				String id = adminEntity.getId();
				// UserAndRoleEntity
				List<UserAndRoleEntity> roleList = this.sysService.findByProperty(UserAndRoleEntity.class, "GeneralUserEntity.id", id);
				for (UserAndRoleEntity userAndRoleEntity : roleList) {
					List<RoleAndFunctionEntity> list = this.sysService.findByProperty(RoleAndFunctionEntity.class, "RoleEntity.id", userAndRoleEntity.getId());
				}
			}

		}
*/

		// Subject currentUser = SecurityUtils.getSubject();
		// AuthUserVO user = (AuthUserVO)
		// currentUser.getSession().getAttribute("userInfo");
		// GeneralUserEntity userEntity =
		// this.sysService.get(GeneralUserEntity.class, user.getId());
		// if (userEntity != null) {
		// List<UserAndRoleEntity> userAndRoleList = userEntity.getRoles();
		// for (UserAndRoleEntity ur : userAndRoleList) {
		// RoleEntity role = ur.getRole();
		// roleNames.add(role.getCode());
		// List<RoleAndFunctionEntity> roleAndFunList = role.getFunctions();
		// for (RoleAndFunctionEntity rf : roleAndFunList) {
		// FunctionEntity fun = rf.getFunction();
		// permissions.add(fun.getValue());
		// }
		// }
		// } else {
		// // HXUser tsuser = this.sysService.get(HXUser.class, user.getId());
		// // List<TSRoleUser> ruList =
		// // sysService.findByProperty(TSRoleUser.class, "TSUser.id",
		// // user.getId());
		// // for(TSRoleUser ru : ruList){
		// // TSRole role = ru.getTSRole();
		// // roleNames.add(role.getRoleCode());
		// // }
		// }

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;

	}

	/**
	 * 获取身份验证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		/* 这里编写认证代码 */
		GeneralUserEntity userExample = new GeneralUserEntity();
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// User user = securityApplication.findby(upToken.getUsername());
		userExample.setMphone(token.getUsername());

		String username = "";
		String password = "";
		// 查前台用户邮箱
		String hql = "from GeneralUserEntity where email='" + token.getUsername() + "'";
		GeneralUserEntity user = (GeneralUserEntity) sysService.singleResult(hql);
		if (user != null) {
			username = user.getEmail();
			password = user.getPwd();
		} else if ("".equals(username)) {
			// 查前台用户手机号
			String hql2 = "from GeneralUserEntity where mphone='" + token.getUsername() + "'";
			user = (GeneralUserEntity) sysService.singleResult(hql2);
			if (user != null) {
				username = user.getMphone();
				password = user.getPwd();
			}
		}

		return new SimpleAuthenticationInfo(username, password, getName());
	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

}
