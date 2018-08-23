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