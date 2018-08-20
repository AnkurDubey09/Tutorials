import { ExpectedConditions, by, browser, element } from 'protractor'
import { Event } from '../../event.util';
import { TemplateDesignerAPI } from '../../utils/template-designer-common.api';
import { MainPage } from '../../po/main.po'
import { LegendUtils } from '../../utils/legend.utils';
import { LegendPage } from '../../po/legend.po';
import { OptionsPage } from '../../po/options.po';
import { LoginPage } from '../../po/login.po';
import { TDWelcomePage } from '../../po/tdwelcome.po';
import { TDTablesPage } from '../../po/tdTables.po';
import { TDTableDetailsPage } from '../../po/tdTableDetails.po';
import { TDCreationPage } from '../../po/tdCreation.po';
import { TDAddColumnPage } from '../../po/tdAddColumn.po';
import { TDBarChartPage } from '../../po/tdBarChart.po';
import { TDPieChartPage } from '../../po/tdPieChart.po';
import { TDStreetImageryPage } from '../../po/tdStreetImagery.po';
import { TDAddTextPage } from '../../po/tdAddText.po';
import { MainUtils } from '../../utils/main.utils';
import { By } from '../../node_modules/@types/selenium-webdriver';

describe('@Tepmlate designer:: ', function () {
    let mainPage: MainPage = new MainPage();
    let event: Event;
    let legendUtil: LegendUtils = new LegendUtils();
    let optionsPage: OptionsPage = new OptionsPage();
    let loginPage: LoginPage = new LoginPage();
    let tdWelcomPage: TDWelcomePage = new TDWelcomePage();
    let tdTablesPage: TDTablesPage = new TDTablesPage();
    let tdTableDetails: TDTableDetailsPage = new TDTableDetailsPage();
    let tdCreationPage: TDCreationPage = new TDCreationPage();
    let tdAddColumnPage: TDAddColumnPage = new TDAddColumnPage();
    let tdBarChartPage: TDBarChartPage = new TDBarChartPage();
    let tdPieChartPage: TDPieChartPage = new TDPieChartPage();
    let tdStreetImagery: TDStreetImageryPage = new TDStreetImageryPage();
    let tdAddText: TDAddTextPage = new TDAddTextPage();
    let tdAPI: TemplateDesignerAPI = new TemplateDesignerAPI();

    let tData = require('../../data/template_data.json');

    beforeEach(function () {
        //event = new Event();
        
        mainPage.navigateTo();
        mainPage.optionButton.click().then(()=>{

            optionsPage.loginlink.click().then(()=>{
                loginPage.userNameField.sendKeys('admin');
                loginPage.passwordField.sendKeys('admin');
                loginPage.signInButton.click();
            })

        })


    });

    it('TD-01: should verify the UI for all panels.', () => {

        //browser.sleep(5000);
        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;

        let dataIndex = 1;
        let templateData = tData.data_array[dataIndex];
        let table_name = templateData.table.table_name;
        
        optionsPage.templateDesignerLink.click().then(() => {
            tdWelcomPage.getStartedButton.click().then(() => {
                tdTablesPage.tableInputField.sendKeys(table_name);
                tdTablesPage.allListedTables.get(0).click().then(() => {
                    tdTableDetails.createNewTemplateButton.click().then(() => {
                        expect(tdCreationPage.saveAsButton.isEnabled()).toBe(false);
                        expect(tdCreationPage.saveButton.isEnabled()).toBe(false);
                        expect(tdCreationPage.previewAndReorderText.getText()).toBe('Preview and re-order');
                        expect(tdCreationPage.homeMenu.getText()).toBe('Home');
                        expect(tdCreationPage.tableNameOnMenu.getText()).toBe('New template ( '+table_name+' )');
                        expect(tdAddColumnPage.chooseYourColumnText.getText()).toBe('Choose your column');
                        expect(tdAddColumnPage.setPropertyText.getText()).toBe('Set property');
                        expect(tdAddColumnPage.allCheckBoxLabel.getText()).toBe('All');
                        expect(tdAddColumnPage.hideSectionCheckBoxLabel.getText()).toBe('Hide section when value is null');
                        expect(tdAddColumnPage.showIconLabel.getText()).toBe('Show Icon');
                        expect(tdAddColumnPage.showLabelsLabel.getText()).toBe('Show labels');
                        expect(tdAddColumnPage.inlineLabelsLabel.getText()).toBe('Inline labels');
                        expect(tdAddColumnPage.labelAboveValueLabel.getText()).toBe('Label above value');
                        expect(tdAddColumnPage.infoText.getText()).toBe('You need to add the space if you wish to have a space between prefix and the value or before the suffix and the value.');
                        expect(tdAddColumnPage.prefixLabel.getText()).toBe('Prefix');
                        expect(tdAddColumnPage.suffixLabel.getText()).toBe('Suffix');
                    });

                });
            });
        });
        tdCreationPage.barChartButton.click();
        tdBarChartPage.addNewBarChartButton.click().then(() => {
            expect(tdBarChartPage.titleOfBarChartLabels.get(0).getText()).toBe('Title of Bar Chart');
            expect(tdBarChartPage.valueOfChartRepresentLabels.get(0).getText()).toBe('Value your chart represents (shown as label for axis)');
            expect(tdBarChartPage.chartLayoutLabels.get(0).getText()).toBe('Chart Layout');
            expect(tdBarChartPage.chooseColumnsLabels.get(0).getText()).toBe('Choose columns *');
            expect(tdBarChartPage.horizontalBarsLabels.get(0).getText()).toBe('Horizontal bars');
            expect(tdBarChartPage.verticalBarsLabels.get(0).getText()).toBe('Vertical bars');
            expect(tdBarChartPage.allCheckLabel.get(0).getText()).toBe('All');
        });
        tdBarChartPage.deleteButtonsOnBarChartPanel.click();
        tdCreationPage.pieChartButton.click();
        tdPieChartPage.addNewPieChartButton.click().then(() => {
            expect(tdPieChartPage.titleOfPieChartLabels.get(0).getText()).toBe('Title of Pie Chart');
            expect(tdPieChartPage.chooseColumnsLabels.get(0).getText()).toBe('Choose columns *');
            expect(tdPieChartPage.allCheckLabel.get(0).getText()).toBe('All');
        });
        tdPieChartPage.deleteButtonsOnPieChartPanel.click();
        tdCreationPage.streetImageryButton.click().then(() => {
            let alertMSG = 'To setup Google street view you need to configure Google Api Key in admin console. Google Api Key need to be purchased by your organization. Learn more';
            expect(tdStreetImagery.setupGoogleAlertInfo.getText()).toBe(alertMSG);
            expect(tdStreetImagery.addGoogleStreetLabel.getText()).toBe('Add Google street view');
            expect(tdStreetImagery.showStreetViewFromLabel.getText()).toBe('Show street view from');
            expect(tdStreetImagery.mapClickLabel.getText()).toBe('Map click');
            expect(tdStreetImagery.bearingLabel.getText()).toBe('Bearing (optional)');
            expect(tdStreetImagery.specificCoordinateFromTableLabel.getText()).toBe('Specific coordinate from table');
        });
        tdStreetImagery.specificCoordinateFromTableRadioButton.click().then(() => {
            expect(tdStreetImagery.projectionLabel.getText()).toBe('Projection *');
            expect(tdStreetImagery.longitudeOrXLabel.getText()).toBe('X or longitude *');
            expect(tdStreetImagery.latitudeOrYLabel.getText()).toBe('Y or latitude *');
            //expect(tdStreetImagery.alertInfo.getText()).toBe('');
            expect(tdStreetImagery.tableProjectionAlertInfo.getText()).toBe('The table projection is selected by default.');
        });
        tdStreetImagery.mapClickRadioButton.click();
        tdCreationPage.textCreationButton.click().then(() => {
            tdAddText.addNewTextButton.click().then(() => {
                expect(tdAddText.addTextHereLabels.get(0).getText()).toBe('Add text here *');
                expect(tdAddText.selectStyleLabels.get(0).getText()).toBe('Select style');
                expect(tdAddText.styleInheritInfoLabels.get(0).getText()).toBe("Style would be inherited from 'brand.css'");
                
                expect(tdAddText.h1Buttons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.h2Buttons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.h3Buttons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.h4Buttons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.h5Buttons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.h6Buttons.get(0).isDisplayed()).toBe(true);
                // expect(tdAddText.h4Buttons.get(0).isSelected()).toBe(true); // default selection
                // expect(tdAddText.centerAlignButtons.get(0).isSelected()).toBe(true); // default selection
                expect(tdAddText.centerAlignButtons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.leftAlignButtons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.rightAlignButtons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.boldButtons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.italicButtons.get(0).isDisplayed()).toBe(true);
                expect(tdAddText.underlineButtons.get(0).isDisplayed()).toBe(true);

            })

        });


    });

    it('TD-02: should verify the UI for all panels.', () => {

        //browser.sleep(5000);
        let dataIndex = 0;
        let templateData = tData.data_array[dataIndex];
        let table_name = templateData.table.table_name;

        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;
        optionsPage.templateDesignerLink.click().then(() => {
            tdWelcomPage.getStartedButton.click().then(() => {
                tdTablesPage.tableInputField.sendKeys('ABank');
                tdTablesPage.allListedTables.get(0).click().then(() => {
                    tdTableDetails.createNewTemplateButton.click().then(() => {

                        if (templateData.add_column.enabled) {
                            let len = templateData.add_column.columns.length;
                            for (let i = 0; i < len; i++) {
                                tdAddColumnPage.allColumnsCheckboxes.get(templateData.add_column.columns[i].col.index).click().then(() => {

                                    //expect(tdAddColumnPage.columnNameOnSetPropertyPanel.getText()).toBe(templateData.add_column.columns[i].col.name);
                                    
                                    if (templateData.add_column.columns[i].show_label.enable) {
                                        tdAddColumnPage.showLabelsInputBox.sendKeys(templateData.add_column.columns[i].show_label.value);
                                    }

                                    if (templateData.add_column.columns[i].label_above_value) {
                                        tdAddColumnPage.labelAboveValueCheckBox.click();
                                    } else {
                                        tdAddColumnPage.inlineLabelsCheckBox.click();
                                    }

                                    if (templateData.add_column.columns[i].show_icon.enable) {
                                        tdAddColumnPage.showIconCheckBox.click();
                                        tdAddColumnPage.iconSelectionButton.click().then(() => {
                                            tdAddColumnPage.iconListOnModalBox.get(templateData.add_column.columns[i].show_icon.icon_num).click();
                                        });
                                    }

                                    if (templateData.add_column.columns[i].col.type !== 'string' && templateData.add_column.columns[i].prefix !== '') {
                                        tdAddColumnPage.prefixInputBox.sendKeys('PFX');
                                    }

                                    if (templateData.add_column.columns[i].col.type !== 'string' && templateData.add_column.columns[i].suffix !== '') {
                                        tdAddColumnPage.suffixInputBox.sendKeys('SFX');
                                    }

                                });

                            }
                        }

                        if (templateData.bar_chart.enabled) {
                            let len = templateData.bar_chart.bcharts.length;
                            tdCreationPage.barChartButton.click().then(()=>{
                                for (let i = 0; i < len; i++) {
                                    tdBarChartPage.addNewBarChartButton.click();

                                    tdBarChartPage.titleOfBarChartInputBoxes.get(i).sendKeys(templateData.bar_chart.bcharts[i].title);
                                    tdBarChartPage.valueOfChartRepresentInputBoxes.get(i).sendKeys(templateData.bar_chart.bcharts[i].chart_represents);

                                    if (templateData.bar_chart.bcharts[i].layout === 'horizontal') {
                                        tdBarChartPage.horizontalBarsRadioButtons.get(i).click();
                                    } else if (templateData.bar_chart.bcharts[i].layout === 'vertical') {
                                        tdBarChartPage.verticalBarsRadioButtons.get(i).click();
                                    }
                                    tdBarChartPage.allCheckBoxes.get(i).click();
                                }
                            }); 
                        }

                        if (templateData.pie_chart.enabled) {
                            let len = templateData.bar_chart.bcharts.length;
                            tdCreationPage.pieChartButton.click().then(()=>{
                                for (let i = 0; i < len; i++) {
                                    tdPieChartPage.addNewPieChartButton.click();
                                    tdPieChartPage.titleOfPieChartInputBoxes.get(i).sendKeys(templateData.pie_chart.pcharts[i].title);
                                    browser.actions().mouseMove(tdPieChartPage.allCheckBoxes.get(i)).perform();
                                    tdPieChartPage.allCheckBoxes.get(i).click();
                                }
                            });
                        }

                        if(templateData.street_imagery.enabled){
                            tdCreationPage.streetImageryButton.click().then(() => {
                                
                            });
                        }//browser.sleep(20000);

                        if(templateData.add_text.enabled){
                            let len = templateData.add_text.text.length;
                            tdCreationPage.textCreationButton.click().then(()=>{
                                for (let i = 0; i < len; i++) {
                                    tdAddText.addNewTextButton.click();
                                    tdAddText.textAreas.get(i).sendKeys(templateData.add_text.text[i].value);
                                    switch (templateData.add_text.text[i].text_heading_type) {
                                        case 'h1':
                                            tdAddText.h1Buttons.get(i).click();
                                            break;
                                        case 'h2':
                                            tdAddText.h2Buttons.get(i).click();
                                            break;
                                        case 'h3':
                                            tdAddText.h3Buttons.get(i).click();
                                            break;
                                        case 'h4':
                                            tdAddText.h4Buttons.get(i).click();
                                            break;
                                        case 'h5':
                                            tdAddText.h5Buttons.get(i).click();
                                            break;
                                        case 'h6':
                                            tdAddText.h6Buttons.get(i).click();
                                            break;
                                    }
                                    switch (templateData.add_text.text[i].text_align_type) {
                                        case 'left':
                                            tdAddText.leftAlignButtons.get(i).click();
                                            break;
                                        case 'right':
                                            tdAddText.rightAlignButtons.get(i).click();
                                            break;
                                        case 'center':
                                            tdAddText.centerAlignButtons.get(i).click();
                                            break;
                                    }
                                    if(templateData.add_text.text[i].text_bold){
                                        browser.actions().mouseMove(tdAddText.boldButtons.get(i)).perform();
                                        tdAddText.boldButtons.get(i).click();
                                    }else if(templateData.add_text.text[i].boldButtons){
                                        browser.actions().mouseMove(tdAddText.boldButtons.get(i)).perform();
                                        tdAddText.italicButtons.get(i).click();
                                    }else if(templateData.add_text.text[i].text_underline){
                                        browser.actions().mouseMove(tdAddText.underlineButtons.get(i)).perform();
                                        tdAddText.underlineButtons.get(i).click();
                                    }
                                    
                                }
                            })
                            
                        } browser.sleep(20000);

                    });

                });
            });
        });

    });

    it('TD-02: should verify the UI for all panels.', () => {

        
        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        browser.ignoreSynchronization = false;
        optionsPage.templateDesignerLink.click().then(() => {

            tdWelcomPage.getStartedButton.click().then(() => {
                 
                let ini = tData.automate == -1? 0 : tData.automate;
                let len = (tData.automate == -1? tData.data_array.length : ini+1);
                                
                for (let ind = ini; ind < len; ind++) {

                    //let dataIndex = 1;
                    let templateData = tData.data_array[ind];
                    let table_name = templateData.table.table_name;
                    tdTablesPage.tableInputField.sendKeys(table_name);
                    tdTablesPage.allListedTables.get(0).click().then(() => {

                        tdTableDetails.createNewTemplateButton.click().then(() => {

                            if (templateData.add_column.enabled) {
                                tdAPI.add_columns_to_template(ind);
                            }

                            if (templateData.bar_chart.enabled) {
                                tdCreationPage.barChartButton.click();
                                tdAPI.add_bar_to_template(ind);
                            }

                            if (templateData.pie_chart.enabled) {
                                tdCreationPage.pieChartButton.click();
                                tdAPI.add_pie_to_template(ind);
                            }

                            if (templateData.street_imagery.enabled) {
                                tdCreationPage.streetImageryButton.click();
                                tdAPI.add_street_imagery_to_template(ind);
                            }

                            if (templateData.add_text.enabled) {
                                tdCreationPage.textCreationButton.click();
                                tdAPI.add_text_to_template(ind);
                            } //browser.sleep(40000);

                        });

                    });//browser.sleep(10000);

                    tdCreationPage.saveButton.click().then(() => {
                        tdCreationPage.saveTemplateModalInputBox.sendKeys(templateData.template_name.create_template);
                        tdCreationPage.saveTempalteModalSaveButton.click();
                        tdCreationPage.savedTemplateBoxOkButton.click();
                    });

                    tdCreationPage.homeMenu.click();

                }
                

            });

             //browser.close();

        });

    });

    it('TD-03: should verify the UI for add column panel.', ()=> {

        //browser.sleep(5000);
        let dataIndex = 0;
        let templateData = tData.data_array[dataIndex];
        let table_name = templateData.table.table_name;

        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;
        optionsPage.templateDesignerLink.click().then(() => {
            tdWelcomPage.getStartedButton.click().then(() => {
                tdTablesPage.tableInputField.sendKeys('ABank');
                tdTablesPage.allListedTables.get(0).click().then(() => {
                    tdTableDetails.createNewTemplateButton.click().then(() => {
                        expect(tdCreationPage.saveAsButton.isEnabled()).toBe(false);
                        expect(tdCreationPage.saveButton.isEnabled()).toBe(false);
                        expect(tdCreationPage.previewAndReorderText.getText()).toBe('Preview and re-order');
                        expect(tdCreationPage.homeMenu.getText()).toBe('Home');
                        expect(tdCreationPage.tableNameOnMenu.getText()).toBe('New template ( ABank )');
                        expect(tdAddColumnPage.chooseYourColumnText.getText()).toBe('Choose your column');
                        expect(tdAddColumnPage.setPropertyText.getText()).toBe('Set property');
                        expect(tdAddColumnPage.allCheckBoxLabel.getText()).toBe('All');
                        expect(tdAddColumnPage.hideSectionCheckBoxLabel.getText()).toBe('Hide section when value is null');
                        expect(tdAddColumnPage.showIconLabel.getText()).toBe('Show Icon');
                        expect(tdAddColumnPage.showLabelsLabel.getText()).toBe('Show labels');
                        expect(tdAddColumnPage.inlineLabelsLabel.getText()).toBe('Inline labels');
                        expect(tdAddColumnPage.labelAboveValueLabel.getText()).toBe('Label above value');
                        expect(tdAddColumnPage.infoText.getText()).toBe('You need to add the space if you wish to have a space between prefix and the value or before the suffix and the value.');
                        expect(tdAddColumnPage.prefixLabel.getText()).toBe('Prefix');
                        expect(tdAddColumnPage.suffixLabel.getText()).toBe('Suffix');
                    });
                        let len = templateData.add_column.columns.length;
                        for (let i = 0; i < len; i++) {
                            let cnt=i+1;
                            console.log('##############################');
                            console.log(templateData.add_column.columns[i].col.name);
                            console.log(templateData.add_column.columns[i].show_icon.enable);
                            console.log(templateData.add_column.columns[i].show_icon.icon_num);

                            tdAddColumnPage.allColumnsCheckboxes.get(templateData.add_column.columns[i].col.index).click().then(() => {

                                expect(tdAddColumnPage.columnNameOnSetPropertyPanel.getText()).toBe(templateData.add_column.columns[i].col.name);
                                expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(cnt);

                                if(templateData.add_column.columns[i].show_label.enable){
                                    tdAddColumnPage.showLabelsInputBox.sendKeys(templateData.add_column.columns[i].show_label.value);
                                }

                                if(templateData.add_column.columns[i].label_above_value){
                                    tdAddColumnPage.labelAboveValueCheckBox.click();
                                }else{
                                    tdAddColumnPage.inlineLabelsCheckBox.click();
                                }
                                
                                if (templateData.add_column.columns[i].show_icon.enable) {
                                    tdAddColumnPage.showIconCheckBox.click();
                                    tdAddColumnPage.iconSelectionButton.click().then(() => {
                                        tdAddColumnPage.iconListOnModalBox.get(templateData.add_column.columns[i].show_icon.icon_num).click();
                                    });
                                }

                                if (templateData.add_column.columns[i].col.type !== 'string') {
                                    tdAddColumnPage.prefixInputBox.sendKeys('PFX');
                                    tdAddColumnPage.suffixInputBox.sendKeys('SFX');
                                }
                                
                            });

                        }
                        /*tdCreationPage.selectedOptionsXButtonOnPreviewPanel.each((el, ind) => {console.log('index is ************* ', ind);
                            el.click();
                        });*/

                        for (let i=0; i<len; i++){
                            tdCreationPage.selectedOptionsXButtonOnPreviewPanel.get(0).click();
                        }
                        expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(0);

                        /*
                    tdAddColumnPage.allColumnsCheckboxes.get(1).click().then(() => {
                        expect(tdCreationPage.saveAsButton.isEnabled()).toBe(false);
                        expect(tdCreationPage.saveButton.isEnabled()).toBe(true);
                        //                 expect(tdAddColumnPage.showLabelsCheckBox.isSelected()).toBe(true);
                        expect(tdAddColumnPage.showLabelsInputBox.isEnabled()).toBe(true);
                        expect(tdAddColumnPage.showIconCheckBox.isSelected()).toBe(false);
                        //                 expect(tdAddColumnPage.inlineLabelsCheckBox.isSelected()).toBe(true);
                        expect(tdAddColumnPage.labelAboveValueCheckBox.isSelected()).toBe(false);
                        expect(tdAddColumnPage.iconSelectionButton.isEnabled()).toBe(false);
                        tdAddColumnPage.showLabelsCheckBox.click().then(() => {
                            expect(tdAddColumnPage.showLabelsInputBox.isEnabled()).toBe(false);
                            //                     expect(tdAddColumnPage.inlineLabelAboveValueContainer.isEnabled()).toBe(false);
                            expect(tdAddColumnPage.inlineLabelAboveValueContainer.getAttribute('class')).toContain('disableContainer');
                        });
                        tdAddColumnPage.showIconCheckBox.click().then(() => {
                            expect(tdAddColumnPage.iconSelectionButton.isEnabled()).toBe(true);
                        });
                        tdAddColumnPage.iconSelectionButton.click().then(() => {
                            expect(tdAddColumnPage.chooseIconsModalBoxHeaderText.getText()).toBe('Choose icon');
                            tdAddColumnPage.chooseIconsModalBoxXButton.click();
                        });
                        tdAddColumnPage.iconSelectionButton.click().then(() => {
                            tdAddColumnPage.iconListOnModalBox.get(5).click();
                        });
                        expect(tdAddColumnPage.prefixInputBox.getAttribute('value')).toBe('');
                        expect(tdAddColumnPage.suffixInputBox.getAttribute('value')).toBe('');
                        expect(tdAddColumnPage.prefixInputBox.getAttribute('maxlength')).toBe('16');
                        expect(tdAddColumnPage.suffixInputBox.getAttribute('maxlength')).toBe('16');
                        tdAddColumnPage.prefixInputBox.sendKeys('PFX');
                        tdAddColumnPage.suffixInputBox.sendKeys('SFX');
                        tdAddColumnPage.hideSectionCheckBox.click();
                        expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(1);
                        expect(tdCreationPage.selectedColumnNameOnPreviewPanel.getText()).toContain('Regulatory_ID');
                        tdCreationPage.selectedOptionsXButtonOnPreviewPanel.get(0).click().then(() => {
                            expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(0);
                            expect(tdAddColumnPage.allColumnsCheckboxes.get(1).isSelected()).toBe(false);
                        });*/
                        
                        /*
                        tdAddColumnPage.allColumnsCheckboxes.get(1).click().then(() => {
                            expect(tdAddColumnPage.columnNameOnSetPropertyPanel.getText()).toBe('Regulatory_ID(Integer)');
                            expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(1);
                            tdAddColumnPage.showLabelsCheckBox.click();
                            tdAddColumnPage.showLabelsInputBox.sendKeys('RegulatoryID');
                            tdAddColumnPage.labelAboveValueCheckBox.click();
                            tdAddColumnPage.iconSelectionButton.click().then(() => {
                                tdAddColumnPage.iconListOnModalBox.get(2).click();
                            });
                        });
                        
                        tdAddColumnPage.allColumnsCheckboxes.get(2).click().then(() => {
                            expect(tdAddColumnPage.columnNameOnSetPropertyPanel.getText()).toBe('Branch_number(Integer)');
                            expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(2);
                            tdAddColumnPage.showLabelsInputBox.sendKeys('BranchNumber');
                            tdAddColumnPage.labelAboveValueCheckBox.click();
                            tdAddColumnPage.showIconCheckBox.click();
                            tdAddColumnPage.iconSelectionButton.click().then(() => {
                                tdAddColumnPage.iconListOnModalBox.get(4).click();
                            });
                            tdAddColumnPage.prefixInputBox.sendKeys('PFX');
                            tdAddColumnPage.suffixInputBox.sendKeys('SFX');
                        });
                        tdAddColumnPage.allColumnsCheckboxes.get(4).click().then(() => {
                            expect(tdAddColumnPage.columnNameOnSetPropertyPanel.getText()).toBe('Address(String)');
                            expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(3);
                            tdAddColumnPage.showLabelsInputBox.sendKeys('Address');
                            tdAddColumnPage.labelAboveValueCheckBox.click();
                            tdAddColumnPage.showIconCheckBox.click();
                            tdAddColumnPage.iconSelectionButton.click().then(() => {
                                tdAddColumnPage.iconListOnModalBox.get(6).click();
                            });
                        });
                        tdAddColumnPage.allColumnsNames.get(1).click(); browser.sleep(2000);
                        tdAddColumnPage.allColumnsNames.get(2).click(); browser.sleep(2000);
                        tdAddColumnPage.allColumnsNames.get(4).click(); browser.sleep(2000);
                        tdCreationPage.selectedOptionsXButtonOnPreviewPanel.each((el, ind) => {
                            el.click();
                        });
                        expect(tdCreationPage.selectedOptionsOnPreviewPanel.count()).toBe(0);
                    });*/
                });
            });
        });


    });

    it('TD-04: should verify the UI for bar chart panel.', ()=>{
        let dataIndex = 0;
        let templateData = tData.data_array[dataIndex];
        let table_name = templateData.table.table_name;

        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;

        optionsPage.templateDesignerLink.click();
        tdWelcomPage.getStartedButton.click();
        tdTablesPage.tableInputField.sendKeys('ABank');
        tdTablesPage.allListedTables.get(0).click();
        tdTableDetails.createNewTemplateButton.click().then(() => {
            tdCreationPage.barChartButton.click();
            tdBarChartPage.addNewBarChartButton.click().then(() => {
                expect(tdBarChartPage.titleOfBarChartLabels.get(0).getText()).toBe('Title of Bar Chart');
                expect(tdBarChartPage.valueOfChartRepresentLabels.get(0).getText()).toBe('Value your chart represents (shown as label for axis)');
                expect(tdBarChartPage.chartLayoutLabels.get(0).getText()).toBe('Chart Layout');
                expect(tdBarChartPage.chooseColumnsLabels.get(0).getText()).toBe('Choose columns *');
                expect(tdBarChartPage.horizontalBarsLabels.get(0).getText()).toBe('Horizontal bars');
                expect(tdBarChartPage.verticalBarsLabels.get(0).getText()).toBe('Vertical bars');
                expect(tdBarChartPage.allCheckLabel.get(0).getText()).toBe('All');
            });
        });

        let len = templateData.bar_chart.bcharts.length;
        for (let i = 0; i < len; i++) {
            let cnt = i;
            tdBarChartPage.addNewBarChartButton.click();

            tdBarChartPage.titleOfBarChartInputBoxes.get(i).sendKeys(templateData.bar_chart.bcharts[i].title);
            tdBarChartPage.valueOfChartRepresentInputBoxes.get(i).sendKeys(templateData.bar_chart.bcharts[i].chart_represents);

            if(templateData.bar_chart.bcharts[i].layout === 'horizontal'){
                tdBarChartPage.horizontalBarsRadioButtons.get(i).click();
            }else if(templateData.bar_chart.bcharts[i].layout === 'vertical'){
                tdBarChartPage.verticalBarsRadioButtons.get(i).click();
            }            
            tdBarChartPage.allCheckBoxes.get(i).click();
        }
        
    });

    it('TD-05: should verify the UI for pie chart panel.', ()=>{
        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;

        optionsPage.templateDesignerLink.click();
        tdWelcomPage.getStartedButton.click();
        tdTablesPage.tableInputField.sendKeys('ABank');
        tdTablesPage.allListedTables.get(0).click();
        tdTableDetails.createNewTemplateButton.click().then(() => {
            tdCreationPage.pieChartButton.click();
            tdPieChartPage.addNewPieChartButton.click().then(() => {
                expect(tdPieChartPage.titleOfPieChartLabels.get(0).getText()).toBe('Title of Pie Chart');
                expect(tdPieChartPage.chooseColumnsLabels.get(0).getText()).toBe('Choose columns *');
                expect(tdPieChartPage.allCheckLabel.get(0).getText()).toBe('All');
            });
        });

        let dataIndex = 0;
        let templateData = tData.data_array[dataIndex];
        let table_name = templateData.table.table_name;
        let len = templateData.bar_chart.bcharts.length;

        for (let i = 0; i < len; i++) {
            let cnt = i;
            tdPieChartPage.addNewPieChartButton.click();
            tdPieChartPage.titleOfPieChartInputBoxes.get(i).sendKeys(templateData.pie_chart.pcharts[i].title);        
            tdPieChartPage.allCheckBoxes.get(i).click();
        }
        
    });

    it('TD-06: should verify the UI for street imagery panel.', ()=>{
        

        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;

        optionsPage.templateDesignerLink.click();
        tdWelcomPage.getStartedButton.click();
        tdTablesPage.tableInputField.sendKeys('ABank');
        tdTablesPage.allListedTables.get(0).click();
        tdTableDetails.createNewTemplateButton.click().then(() => {
            tdCreationPage.streetImageryButton.click().then(()=>{
                let alertMSG = 'To setup Google street view you need to configure Google Api Key in admin console. Google Api Key need to be purchased by your organization. Learn more';
                expect(tdStreetImagery.setupGoogleAlertInfo.getText()).toBe(alertMSG);
                expect(tdStreetImagery.addGoogleStreetLabel.getText()).toBe('Add Google street view');
                expect(tdStreetImagery.showStreetViewFromLabel.getText()).toBe('Show street view from');
                expect(tdStreetImagery.mapClickLabel.getText()).toBe('Map click');
                expect(tdStreetImagery.bearingLabel.getText()).toBe('Bearing (optional)');
                expect(tdStreetImagery.specificCoordinateFromTableLabel.getText()).toBe('Specific coordinate from table');                
            });
            tdStreetImagery.specificCoordinateFromTableRadioButton.click().then(() => {
                expect(tdStreetImagery.projectionLabel.getText()).toBe('Projection *');
                expect(tdStreetImagery.longitudeOrXLabel.getText()).toBe('X or longitude *');
                expect(tdStreetImagery.latitudeOrYLabel.getText()).toBe('Y or latitude *');
                //expect(tdStreetImagery.alertInfo.getText()).toBe('');
                expect(tdStreetImagery.tableProjectionAlertInfo.getText()).toBe('The table projection is selected by default.');
            });
            tdStreetImagery.bearingDropdown.click().then(()=>{
                tdStreetImagery.bearingDropdownValues.get(3).click();
            });
            
        });
        
    });

    it('TD-07: should verify the UI for text panel.', ()=>{
        
        browser.ignoreSynchronization = true;
        browser.waitForAngular();
        browser.sleep(40000);
        mainPage.optionButton.click();
        //expect(optionsPage.templateDesignerLink.getText()).toBe('Template Designer');
        browser.ignoreSynchronization = false;

        optionsPage.templateDesignerLink.click();
        tdWelcomPage.getStartedButton.click();
        tdTablesPage.tableInputField.sendKeys('ABank');
        tdTablesPage.allListedTables.get(0).click();
        tdTableDetails.createNewTemplateButton.click().then(() => {
            tdCreationPage.textCreationButton.click().then(()=>{
                tdAddText.addNewTextButton.click().then(()=>{
                    expect(tdAddText.addTextHereLabels.get(0).getText()).toBe('Add text here *');
                    expect(tdAddText.selectStyleLabels.get(0).getText()).toBe('Select style');
                    expect(tdAddText.styleInheritInfoLabels.get(0).getText()).toBe("Style would be inherited from 'brand.css'");
                    /*expect(tdAddText.h1Buttons.get(0).getText()).toBe('H1');
                    expect(tdAddText.h2Buttons.get(0).getText()).toBe('H2');
                    expect(tdAddText.h3Buttons.get(0).getText()).toBe('H3');
                    expect(tdAddText.h4Buttons.get(0).getText()).toBe('H4');
                    expect(tdAddText.h5Buttons.get(0).getText()).toBe('H5');
                    expect(tdAddText.h6Buttons.get(0).getText()).toBe('H6');*/
                    expect(tdAddText.h1Buttons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.h2Buttons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.h3Buttons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.h4Buttons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.h5Buttons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.h6Buttons.get(0).isDisplayed()).toBe(true);
                   // expect(tdAddText.h4Buttons.get(0).isSelected()).toBe(true); // default selection
                   // expect(tdAddText.centerAlignButtons.get(0).isSelected()).toBe(true); // default selection
                    expect(tdAddText.centerAlignButtons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.leftAlignButtons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.rightAlignButtons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.boldButtons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.italicButtons.get(0).isDisplayed()).toBe(true);
                    expect(tdAddText.underlineButtons.get(0).isDisplayed()).toBe(true);

                })
            
            });
            
            
        });
        
    });

   
});

describe('@Admin console to set the template with the table', ()=>{
    let tData = require('../../data/template_data.json');

    it('admin console', ()=>{
        let dataIndex = 1;
        let templateData = tData.data_array[dataIndex];
        let templateName = templateData.template_name.create_template;

        let dLen = tData.data_array.length;


        browser.driver.get('http://localhost:8020/adminconsole/analyst');

        browser.ignoreSynchronization = true;
        //browser.waitForAngular();
        //browser.driver.sleep(40000);

        /*browser.driver.findElement(By.css('[name="j_username"]')).sendKeys('admin');
        browser.driver.findElement(By.css('[name="j_password"]')).sendKeys('admin');
        browser.driver.findElement(By.css('[class="btn-primary"]')).click();
        browser.driver.findElement(By.css('[id="mainTabContainer_tablist_mapconfigstab"]')).click();*/

        element(by.css('[name="j_username"]')).sendKeys('admin');
        element(by.css('[name="j_password"]')).sendKeys('admin');
        element(by.css('[value="Submit"]')).click();
        element(by.css('[id="mainTabContainer_tablist_mapconfigstab"]')).click();
        element(by.css('[id="mapconfiginnertabs_tablist_templateMappingContainer"]')).click();
        browser.driver.sleep(2000);
        element(by.css('li:nth-of-type(1) select[id="mapInformationTemplates"]')).click();
        element.all(by.css('li:nth-of-type(1) [id="mapInformationTemplates"] option')).each((elm, ind)=>{
            elm.getText().then((val)=>{
                if(val === "AutoTemplateABankA"){
                    elm.click();
                }
            })
        });  
        
        element(by.css('li:nth-of-type(2) select[id="mapInformationTemplates"]')).click();
        element.all(by.css('li:nth-of-type(2) [id="mapInformationTemplates"] option')).each((elm, ind)=>{
            elm.getText().then((val)=>{
                if(val === "AutoTemplateBuildingA"){
                    elm.click();
                }
            })
        });  

        element(by.css('[id="mapconfigurationsave"]')).click();
    });
});

describe('@Callout for custom template through template designer', () => {
    let mainPage: MainPage = new MainPage();
    let pageUtil = new LegendUtils();
    const mainUtils: MainUtils = new MainUtils();
    const legendPage: LegendPage = new LegendPage();
    let tData = require('../../data/template_data.json');
    let event: Event;

    beforeEach(()=>{
        mainPage.navigateTo();
        //mainPage.legendButton.click();
        legendPage.navigateTo();
    });

    it('callout verification', () => {
        
        /*let dataIndex = 1;
        let templateData = tData.data_array[dataIndex];
        let table_name = templateData.table.table_name;
        let table_layer_name = templateData.table.table_layer_name;

        let dLen = tData.data_array.length;
        for(let i=0; i<dLen; i++)*/

        let ini = tData.automate == -1 ? 0 : tData.automate;
        let len = (tData.automate == -1 ? tData.data_array.length : ini + 1);

        for (let ind = ini; ind < len; ind++) {
            let templateData = tData.data_array[ind];
            let table_name = templateData.table.table_name;
            let table_layer_name = templateData.table.table_layer_name;

            let coData = [
                { x: 750, y: 373 },
                { x: 950, y: 473 }
            ]

            pageUtil.selectBusinessLayerOnLegend(table_layer_name);
            element(by.css('[id="'+table_layer_name+':'+table_name+':overflow"]')).click().then(() => {
                element(by.css('[id="'+table_layer_name+':zoomTo"]')).click();
            });
            mainUtils.callout({ point: coData[ind] });browser.sleep(20000);

            /*expect(element(by.css('pb-layer-info-container pb-layer-info [class$="accordionHeader wordBreak"]')).get(ind).getText())
                .toBe(table_name);

            expect(element.all(by.css('pb-layer-info-container pb-layer-info [class$="accordionHeader wordBreak"]')).get(ind).count())
                .toBe(1);

            expect(element.all(by.css('pb-layer-info-container pb-layer-info [e2e="calloutContent"]:nth-of-type(1)>div[id="calOutTopNav"] [id="SeeOnMap"]')).get(ind).getText())
                .toContain('See on map');*/

            if (templateData.add_column.enabled) {
                let colLen = templateData.add_column.columns.length;
                for (let i = 0; i < colLen; i++) {

                    if (templateData.add_column.columns[i].show_label.enable && templateData.add_column.columns[i].label_above_value) {
                        expect(element.all(by.css('pb-info-column label')).get(i).getText())
                            .toContain(templateData.add_column.columns[i].show_label.value);
                    } else {
                        expect(element.all(by.css('pb-info-column label')).get(i).getText())
                            .toContain(templateData.add_column.columns[i].col.name);
                    }

                }
            }

            if (templateData.bar_chart.enabled) {
                let barLen = templateData.bar_chart.bcharts.length;
                
                for (let i = 0; i < barLen; i++) {
                    let layout = templateData.bar_chart.bcharts[i].layout;
                    let name = templateData.bar_chart.bcharts[i].title;
                    let chart_represents = templateData.bar_chart.bcharts[i].chart_represents;

                    browser.wait(element.all(by.css('pb-info-bar-chart:nth-of-type(1) google-chart g')).get(0).isDisplayed(),30000);
                    if(layout === "horizontal"){
                        expect(element.all(by.css('pb-info-bar-chart:nth-of-type('+(i+1)+') google-chart svg>g:nth-of-type(1)')).get(0)
                        .getText()).toBe(name);
                        expect(element.all(by.css('pb-info-bar-chart:nth-of-type('+(i+1)+') google-chart svg>g:nth-of-type(3)')).get(0)
                        .getText()).toBe(chart_represents);
                    }else{
                        expect(element.all(by.css('pb-info-bar-chart:nth-of-type('+(i+1)+') google-chart svg>g:nth-of-type(1)')).get(0)
                        .getText()).toBe(name);
                        expect(element.all(by.css('pb-info-bar-chart:nth-of-type('+(i+1)+') google-chart svg>g:nth-of-type(3)')).get(0)
                        .getText()).toBe(chart_represents);
                    }
                }
            }

            if (templateData.pie_chart.enabled) {
                let pieLen = templateData.pie_chart.pcharts.length;
                for (let i = 0; i < pieLen; i++) {
                    let name = templateData.bar_chart.bcharts[i].title;
                    expect(element.all(by.css('pb-info-pie-chart:nth-of-type('+(i+1)+') google-chart g>text')).get(0).getText()).toBe(name);  
                }
            }

            if (templateData.street_imagery.enabled) {
                
            }

            if (templateData.add_text.enabled) {
                let textLen = templateData.add_text.text.length;
                for (let i = 0; i < textLen; i++) {
                    let val = templateData.add_text.text[0].value;
                    let hType = templateData.add_text.text[0].text_heading_type;
                    let align = templateData.add_text.text[0].text_align_type;
                    let bold = templateData.add_text.text[0].text_bold;
                    let italic = templateData.add_text.text[0].text_italic;
                    let underline = templateData.add_text.text[0].text_underline;

                    expect(element.all(by.css('pb-info-text ' + hType + '')).get(i).getText())
                        .toContain(val);

                    expect(element.all(by.css('pb-info-text ' + hType + '')).get(i).getAttribute('class'))
                        .toContain('text-' + align);

                    expect(element.all(by.css('pb-info-text ' + hType + '')).get(i).getAttribute('class'))
                        .toContain('bold');

                    expect(element.all(by.css('pb-info-text ' + hType + '')).get(i).getAttribute('class'))
                        .toContain('underline');

                    expect(element.all(by.css('pb-info-text ' + hType + '')).get(i).getAttribute('class'))
                        .not.toContain('italic');

                }
            }
            pageUtil.selectBusinessLayerOnLegend(table_layer_name);
        }
    });
});