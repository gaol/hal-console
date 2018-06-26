/*
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.hal.resources;

public interface Constants extends com.google.gwt.i18n.client.Constants {

    //@formatter:off
    String abandoned();
    String aborted();
    String accessMechanism();
    String accessType();
    String actions();
    String active();
    String activeFilters();
    String activeLower();
    String activeSessions();
    String add();
    String addAlias();
    String addIdentity();
    String addContent();
    String address();
    String adminOnly();
    String aliases();
    String allMessagesAlways();
    String allMessagesOnce();
    String and();
    String applicationRollback();
    String archived();
    String assignment();
    String assignmentsOfGroup();
    String assignmentsOfUser();
    String attribute();
    String attributes();
    String average();

    String back();
    String backToNormalMode();
    String browse();
    String browseBy();

    String cacheMemory();

    String cacheStore();
    String callerThread();
    String cancel();
    String cancelActiveOperation();
    String cancelNonProgressingOperation();
    String category();
    String changeAlias();
    String changePriority();
    String chooseFile();
    String chooseIdentityPasswordTitle();
    String choosePolicy();
    String chooseSingleton();
    String chooseStrategy();
    String chooseTemplate();
    String clear();
    String clearAll();
    String clearAllFilters();
    String clearCache();
    String clearRunAs();
    String clearRunAsTitle();
    String clearSelection();
    String clone();
    String cloneProfile();
    String close();
    String closed();
    String collapse();
    String configurationSslManagement();
    String committed();
    String completed();
    String completedExecutions();
    String composite();
    String configuration();
    String configurationChanges();
    String configurationChangesNotEnabled();
    String confirmation();
    String connectedTo();
    String connection();
    String connections();
    String connectionPool();
    String connectToServer();
    String consoleVersion();
    String content();
    String contentRepository();
    String copied();
    String copy();
    String copyToClipboard();
    String count();
    String counter();

    String creationTime();
    String currentPage();
    String custom();

    String data();
    String day();
    String days();
    String defaultValue();
    String deploy();
    String deployContent();
    String deployExistingContent();
    String deploymentAttributes();
    String deploymentEmptyCreate();
    String deploymentError();
    String deploymentInProgress();
    String deploymentSuccessful();
    String deployments();
    String description();

    String destroy();
    String details();
    String directory();
    String disable();
    String disableConfigurationChanges();
    String disabled();
    String disableSSL();
    String disconnected();
    String disconnectedUpper();
    String domainConfigurationChanged();
    String domainConfigurationChangedTooltip();
    String domainController();
    String download();
    String dropSubscriptions();
    String duplicateMacro();
    String duration();

    String edit();
    String editIdentity();
    String editURL();
    String enable();
    String enableConfigurationChanges();
    String enabled();
    String enableDeployment();
    String enableRbac();
    String enableSSL();
    String enableSSLManagementErrorMsg();
    String enableSSLManagementTitle();
    String enableSSLManagementInitialSetup();
    String enableStatistics();
    String endpointSelectTitle();
    String endpointSelectDescription();
    String endpointConnect();
    String endpointAddTitle();
    String endpointAddDescription();
    String entry();
    String environment();
    String error();
    String excludeRole();
    String excludeUserGroup();
    String excludes();
    String exclusiveRunningTime();
    String executionStatus();
    String expertMode();
    String expire();
    String expiredSessions();
    String explode();
    String exploded();
    String exportCertificate();
    String expression();
    String expressionResolver();
    String extensionError();
    String extensionNotFound();
    String extensionProcessing();

    String failed();
    String failedExecutions();
    String filter();
    String findNonProgressingOperation();
    String finish();
    String finished();
    String firstPage();
    String flushAll();
    String flushGracefully();
    String flushIdle();
    String flushInvalid();
    String formErrors();
    String formResetDesc();
    String fromDeployment();

    String generateCSR();
    String generateKeyPair();
    String globalSettings();
    String gotoDeployment();
    String group();
    String groups();

    String help();
    String hiddenColumns();
    String hideSensitive();
    String hitCount();
    String homepageNewToEap();
    String homepageTakeATour();
    String homepageDeploymentsSubHeader();
    String homepageDeploymentsSection();
    String homepageDeploymentsStandaloneStepIntro();
    String homepageDeploymentsStandaloneStep1();
    String homepageDeploymentsStepEnable();
    String homepageDeploymentsDomainStepIntro();
    String homepageDeploymentsDomainStep1();
    String homepageDeploymentsDomainStep2();
    String homepageConfigurationStandaloneSubHeader();
    String homepageConfigurationDomainSubHeader();
    String homepageConfigurationSection();
    String homepageConfigurationStepIntro();
    String homepageConfigurationStandaloneStep1();
    String homepageConfigurationDomainStep1();
    String homepageConfigurationStep2();
    String homepageConfigurationStep3();
    String homepageRuntimeStandaloneSubHeader();
    String homepageRuntimeStandaloneSection();
    String homepageRuntimeStepIntro();
    String homepageRuntimeStandaloneStep1();
    String homepageRuntimeStandaloneStep2();
    String homepageRuntimeDomainSubHeader();
    String homepageRuntimeDomainServerGroupSection();
    String homepageRuntimeDomainServerGroupStepIntro();
    String homepageRuntimeDomainServerGroupStep1();
    String homepageRuntimeDomainServerGroupStep2();
    String homepageRuntimeDomainCreateServerSection();
    String homepageRuntimeDomainCreateServerStepIntro();
    String homepageRuntimeDomainCreateServerStep1();
    String homepageRuntimeDomainCreateServerStep2();
    String homepageRuntimeDomainMonitorServerSection();
    String homepageRuntimeDomainMonitorServerStep1();
    String homepageRuntimeDomainMonitorServerStep2();
    String homepageAccessControlSubHeader();
    String homepageAccessControlSection();
    String homepageAccessControlStepIntro();
    String homepageAccessControlStep1();
    String homepageAccessControlStep2();
    String homepageAccessControlSsoSubHeader();
    String homepagePatchingSection();
    String homepagePatchingStep1();
    String homepagePatchingDomainStep2();
    String homepagePatchingStepApply();
    String homepageHelpNeedHelp();
    String homepageHelpGeneralResources();
    String homepageHelpEapDocumentationText();
    String homepageHelpEapDocumentationLink();
    String homepageHelpLearnMoreEapText();
    String homepageHelpLearnMoreEapLink();
    String homepageHelpTroubleTicketText();
    String homepageHelpTroubleTicketLink();
    String homepageHelpTrainingText();
    String homepageHelpTrainingLink();
    String homepageHelpTutorialsLink();
    String homepageHelpTutorialsText();
    String homepageHelpEapCommunityLink();
    String homepageHelpEapCommunityText();
    String homepageHelpEapConfigurationsLink();
    String homepageHelpEapConfigurationsText();
    String homepageHelpKnowledgebaseLink();
    String homepageHelpKnowledgebaseText();
    String homepageHelpConsultingLink();
    String homepageHelpConsultingText();
    String homepageHelpWilfdflyDocumentationText();
    String homepageHelpAdminGuideText();
    String homepageHelpWildflyIssuesText();
    String homepageHelpGetHelp();
    String homepageHelpIrcText();
    String homepageHelpUserForumsText();
    String homepageHelpDevelopersMailingListText();
    String homepageHelpWildFlyHomeText();
    String homepageHelpModelReferenceText();
    String homepageHelpLatestNews();
    String hostNameChanged();
    String hostsUsingThisFilter();
    String hostsUsingThisHandler();
    String hostScopedRole();
    String hour();
    String hours();
    String httpManagementInterface();

    String identity();
    String importCertificate();
    String inactive();
    String includeRole();
    String includeUserGroup();
    String includes();
    String includesAll();
    String includesAllDescription();
    String includesAllHeader();
    String initialize();
    String input();
    String instances();
    String invalidExpression();
    String invalidJson();
    String invalidMetadata();
    String invalidate();
    String invalidateSession();

    String jcaConfiguration();
    String jgroupsRelayAlias();
    String jdbcDriver();
    String jndiNames();
    String jndiTree();

    String kill();

    String largest();

    String lastAccessedTime();
    String lastModified();

    String lastPage();
    String load();
    String loading();
    String loadingPleaseWait();
    String logFile();
    String logFilePreviewError();
    String logFiles();
    String logout();

    String macroEditor();
    String mainAttributes();
    String managed();
    String managementOperations();
    String managementVersion();

    String managementVersionMismatchDescription();
    String manyMessages();
    String markAllRead();
    String maxActiveSessions();
    String maxProcessingTime();
    String maxUsed();
    String maximum();
    String membership();
    String membershipOfRole();
    String message();
    String messages();
    String messageLarge();
    String milliseconds();
    String minimum();
    String minute();
    String minutes();
    String missCount();
    String modelBrowser();
    String monitor();
    String move();

    String nanoseconds();
    String nativeManagementInterface();
    String needsReload();
    String needsRestart();
    String networkError();
    String newContent();
    String next();
    String nextPage();
    String no();
    String noAttributes();
    String noBootErrors();
    String noConfiguredMailServers();
    String noDetails();
    String noExecutions();
    String noHaPolicy();
    String noItems();
    String noMacros();
    String noMatchingItems();
    String noNotifications();
    String noPolicy();
    String noPrincipalsExcluded();
    String noPrincipalsIncluded();
    String noReferenceServer();
    String noResource();
    String noRolesExcluded();
    String noRolesIncluded();
    String noRolesIncludedOrExcluded();
    String noRootLogger();
    String noRootLoggerDescription();
    String noRunningServers();
    String noStore();
    String noTransport();
    String noWrite();
    String notANumber();
    String notEnabled();
    String nothingSelected();

    String of();
    String ok();
    String opened();
    String openInExternalWindow();
    String openInModelBrowser();
    String operationDate();
    String operationFailed();
    String operationMode();
    String operationSuccessful();
    String operation();
    String operations();
    String optionalFields();
    String or();
    String orDragItHere();
    String outcome();
    String output();

    String patchError();
    String patchInProgress();
    String patchSuccessful();
    String pattern();
    String pause();
    String pending();
    String perPage();
    String pin();
    String ping();
    String platform();
    String play();
    String policy();
    String pool();
    String preparedStatementCache();
    String preview();
    String previousPage();
    String processingTime();
    String processors();
    String probe();
    String productName();
    String productVersion();
    String providedBy();
    String prune();
    String pruneDisconnected();
    String pruneExpired();

    String queue();

    String readIdentity();
    String recovery();
    String rejected();
    String references();
    String refresh();
    String rejectedSessions();
    String releaseName();
    String releaseVersion();
    String reload();
    String reloadCRL();
    String reloadRequired();
    String reloadStandaloneTooltip();
    String remoteAddress();
    String remove();
    String removeAlias();
    String removeIdentity();
    String removeContent();
    String rename();
    String replace();
    String replaceContent();
    String request();
    String requests();
    String required();
    String requiredField();
    String reset();
    String resolve();
    String resolveExpression();
    String resolvedValue();
    String resourceRollback();
    String response();
    String restart();
    String restartAllServices();
    String restartJvm();
    String restartNoServices();
    String restartRequired();
    String restartResourceServices();
    String restartStandaloneTooltip();
    String restricted();
    String results();
    String resume();
    String review();
    String role();
    String roles();
    String rollback();
    String rollbackError();
    String rollbackInProgress();
    String rollbackSuccessful();
    String runAs();
    String runAsRoleTitle();
    String running();
    String runningTime();

    String sameOrigin();
    String save();
    String search();
    String second();
    String seconds();
    String security();
    String selectAll();
    String sendToDeadLetter();
    String serverGroupScopedRole();
    String serverName();
    String serverUrlCustom();
    String serverUrlManagementModel();
    String sessionTime();
    String sessionsAvgAliveTime();
    String sessionsMaxAliveTime();
    String setIdentityPasswordTitle();
    String setSecret();
    String setPassword();
    String settings();
    String showAll();
    String showSensitive();
    String size();
    String sizing();
    String specifyNames();
    String specifyParameters();
    String standaloneServer();
    String start();
    String startDelivery();
    String startJob();
    String starting();
    String startMacro();
    String statements();
    String statisticsDisabled();
    String statisticsDisabledHeader();
    String statisticsNotAvailableHeader();
    String status();
    String stop();
    String stopDelivery();
    String stopMacro();
    String stopped();
    String stoppedExecution();
    String storage();
    String store();
    String subscriptions();
    String success();
    String supportsExpressions();
    String suspend();
    String suspended();
    String systemRollback();
    String switchBehaviour();

    String switchNearCache();
    String switchMemory();
    String switchProvider();
    String switchStore();
    String switchToExpressionMode();
    String switchToNormalMode();

    String tags();
    String tailMode();

    String test();
    String testConnection();
    String testConnectionError();
    String testConnectionSuccess();
    String timedOut();
    String timeout();
    String timeouts();
    String toggleDropdown();
    String toggleNavigation();
    String tools();
    String totalProcessingTime();
    String tracking();
    String transactions();
    String type();

    String undeploy();
    String undeployContent();
    String undeployed();
    String unknownError();
    String unknownState();
    String unmanaged();
    String unpin();
    String unsupportedFileType();
    String upload();
    String uploadContent();
    String uploadPatch();
    String uploadDeployment();
    String uploadError();
    String uploadInProgress();
    String uploadNewDeployment();
    String uploadSuccessful();
    String used();
    String user();
    String users();

    String validation();
    String view();
    String viewDetailsAlias();
    String viewInEditor();

    String xaProperties();

    String yes();
    //@formatter:on
}
