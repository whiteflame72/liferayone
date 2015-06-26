create table portletone_PortletOne (
	PortletOneId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	PortletOneDescription VARCHAR(100) null
);

create table portletone_Users (
	usersId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	userPhoto LONG,
	folderDLId LONG
);